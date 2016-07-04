public class DeEnCode {


    public static String decode(String cipherText) {
        cipherText = cipherText.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char currentChar = cipherText.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                sb.append((char) ('A' + ((currentChar - 'A') - 22 + 26) % 26));
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public static String encode(String plainText) {
        plainText = plainText.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                sb.append((char) ('A' + ((currentChar - 'A') + 22) % 26));
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "dp!@msOTL75tr";
        String enc = encode(s);
        String dec = decode(enc);
        System.out.println(enc);
        System.out.println(dec);


        char[] array = s.toCharArray();//获取字符数组
        for (int i = 0; i < array.length; i++)//遍历字符数组
        {
            array[i] = (char) (array[i] ^ 20140908);//对每个数组元素进行异或运算，异或的值可以自己选择
        }
        System.out.println(new String(array));
    }
}
