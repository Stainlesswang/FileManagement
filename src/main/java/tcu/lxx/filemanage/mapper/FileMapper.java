package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tcu.lxx.filemanage.entity.File;

import java.util.List;

/**
 * 每一个方法代表
 */
public interface FileMapper {



    @Insert("INSERT INTO file (type_id,jidu_id,xueyuan_id,office_id,zhuanye_id,course_id,banji_id,count)\n" +
            "VALUES(#{type_id},#{jidu_id},#{xueyuan_id},#{office_id},#{zhuanye_id},#{course_id},#{banji_id},#{count})")
    public int addFile(File file);
    /**
     * SELECT

     f.*,
     t.type,
     j.jidu,
     x.`name` xueyuan,
     o.office,
     z.`name` zhuanye,
     c.course,
     b.`name` banji
     FROM
     file f,
     banji b,
     type t,
     jidu j,
     xueyuan x,
     office o,
     zhuanye z,
     course c
     WHERE
     f.banji_id = b.id AND
     f.type_id = t.type_id AND
     f.jidu_id = j.jidu_id AND
     f.xueyuan_id = x.id AND
     f.office_id = o.office_id AND
     f.zhuanye_id = z.id AND
     f.course_id = c.course_id
     */


    @Select("SELECT\n" +
            "\tf.*,\n" +
            "\tt.type,\n" +
            "\tj.jidu,\n" +
            "\tx.`name` xueyuan,\n" +
            "\to.office,\n" +
            "\tz.`name` zhuanye,\n" +
            "\tc.course,\n" +
            "\tb.`name` banji\n" +
            "FROM\n" +
            "\tfile f,\n" +
            "\tbanji b,\n" +
            "\ttype t,\n" +
            "\tjidu j,\n" +
            "\txueyuan x,\n" +
            "\toffice o,\n" +
            "\tzhuanye z,\n" +
            "\tcourse c\n" +
            "WHERE\n" +
            "\tf.banji_id = b.id  AND\n" +
            "f.type_id = t.type_id AND\n" +
            "f.jidu_id = j.jidu_id and\n" +
            "f.xueyuan_id = x.id AND\n" +
            "f.office_id = o.office_id AND\n" +
            "f.zhuanye_id = z.id AND\n" +
            "f.course_id = c.course_id\n")
    public List<File> getAllFileVo();

    @Delete("delete from file where file_id=#{fileid}")
    public int deleteById(int fileid);


        @Select("select * from file where file_id=#{fileid}")
        public File selctById(int fileid);

        @Update("update file set type_id=#{type_id},jidu_id=#{jidu_id},xueyuan_id=#{xueyuan_id}" +
                ",office_id=#{office_id},zhuanye_id=#{zhuanye_id},course_id=#{course_id},banji_id=#{banji_id},count=#{count} where file_id=#{file_id}")
        public int update(File file);
}
