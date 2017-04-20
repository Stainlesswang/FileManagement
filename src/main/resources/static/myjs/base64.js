function Base64() {



    this.aesencode= function(word){

        var key = CryptoJS.enc.Utf8.parse("sjfk58riw0q91u28");
        var iv  = CryptoJS.enc.Utf8.parse("fjsksl592ow058eu");
        var srcs = CryptoJS.enc.Utf8.parse(word);
        var encrypted = CryptoJS.AES.encrypt(srcs, key, { iv: iv,mode:CryptoJS.mode.CBC});
        return encrypted;
    }



}  