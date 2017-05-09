package tcu.lxx.filemanage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import tcu.lxx.filemanage.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring security的配置文件
 */
@Configuration
@EnableWebSecurity
//用于@PreAuthorize的生效,基于方法的权限控制
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//覆盖默认的spring security提供的配置
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/static/**", "/**/*.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置http头属性网上查询说是跨域问题;下边是三个属性
//        DENY - is a default value. With this the page cannot be displayed in a frame, regardless of the site attempting to do so.
//        SAMEORIGIN - I assume this is what you are looking for, so that the page will be (and can be) displayed in a frame on the same origin as the page itself
//        ALLOW-FROM - Allows you to specify an origin, where the page can be displayed in a frame.
        http.headers().frameOptions().sameOrigin();
        http
                //禁用CSRF保护
                .csrf().disable()
                .authorizeRequests()

                        //任何访问都必须授权
//                .anyRequest().fullyAuthenticated()

                        //配置那些路径可以不用权限访问
                .antMatchers("/**/*.jpg").permitAll()
                .antMatchers("/**/*.png").permitAll()
                .antMatchers("/**/*.gif").permitAll()
                .antMatchers("/**/*.js").permitAll()
                .antMatchers("/**/*.css").permitAll()
                .antMatchers("/**/*.woff").permitAll()
                .antMatchers("/**/*.woff2").permitAll()
                .antMatchers("/**/*.jsp").permitAll()
                .antMatchers("/**/*.html").permitAll()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/fileadd").permitAll()

                //只拦截拦截web访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                        //登陆成功后的处理，因为是API的形式所以不用跳转页面
                .successHandler(new RestAuthenticationSuccessHandler())
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        //登陆失败后的处理
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
        //登出后的处理
//                .logout().logoutSuccessHandler(new RestLogoutSuccessHandler())
//                .and()
        //认证不通过后的处理
//                .exceptionHandling()
//                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder())
        ;
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //密码加密
        return new BCryptPasswordEncoder(16);
    }

    /**
     * 登陆成功后的处理
     */
    public static class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication)
                throws ServletException, IOException {
            System.out.print("/RestAuthenticationSuccessHandler!!!#$#$#########");
//            clearAuthenticationAttributes(request);
            response.sendRedirect("/Management/home");

        }
    }

    /**
     * 登出成功后的处理
     */
    public static class RestLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        @Override
        public void onLogoutSuccess(HttpServletRequest request,
                                    HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
            //Do nothing!
        }
    }

    /**
     * 权限不通过的处理
     */
    public static class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request,
                             HttpServletResponse response,
                             AuthenticationException authException) throws IOException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Authentication Failed: " + authException.getMessage());
            System.out.print("/RestAuthenticationEntryPoint!!!#$#$#########");
        }
    }
}
