class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuffer asb = new StringBuffer(a);
        StringBuffer bsb = new StringBuffer(b);
        asb.reverse();
        bsb.reverse();
        int i = 0;
        int carry = 0;
        int bitsum = 0;
        for(; i < bsb.length(); i++){
            bitsum = carry+Integer.parseInt(asb.charAt(i)+"")+Integer.parseInt(bsb.charAt(i)+"");
            switch(bitsum){
                case 0:
                    carry = 0;
                    asb.setCharAt(i,'0');
                    break;
                case 1:
                    carry = 0;
                    asb.setCharAt(i,'1');
                    break;
                case 2:
                    carry = 1;
                    asb.setCharAt(i,'0');
                    break;
                case 3:
                    carry = 1;
                    asb.setCharAt(i,'1');
                default:
                    ;
            }
        }
        if(i < asb.length()){
            for(;i < asb.length() && carry == 1; i++){
                bitsum = carry+Integer.parseInt(asb.charAt(i)+"");
                switch(bitsum){
                    case 0:
                        carry = 0;
                        asb.setCharAt(i,'0');
                        break;
                    case 1:
                        carry = 0;
                        asb.setCharAt(i,'1');
                        break;
                    case 2:
                        carry = 1;
                        asb.setCharAt(i,'0');
                    default:
                        ;
                }
            }
        }
        if(i == asb.length() && carry == 1)
            asb.append(carry+"");
        asb.reverse();
        return asb.toString();
    }
}
