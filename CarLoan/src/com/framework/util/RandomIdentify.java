package com.framework.util;


public class RandomIdentify {
   // wi =2(n-1)(mod 11)
    final int[] wi = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2}; //

   // verify digit
    final int[] vi = {1,0,'X',9,8,7,6,5,4,3,2}; //

    private int[] ai = new int[18];

     public RandomIdentify() {
      }
   //verify


   //get verify
    public  String getVerify(String eightcardid) { //eightcardid
    int remaining = 0;

    if (eightcardid.length() == 17) {
     int sum = 0;
     for (int i = 0; i < 17; i++) {
     String k = eightcardid.substring(i, i + 1);
     ai[i] = Integer.parseInt(k);
        }
 
     for (int i = 0; i < 17; i++) {
      sum = sum + wi[i]*ai[i];
        }
      remaining = sum % 11;
      return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
 
  }
    else{
     return "������!";
    }
   
    }

    

   //�������  д��ǰ17λ

    public String getSheng(){
     // ��һ��λ ǰ��λ 01- 64
        // int number = (int)(Math.random()*(tonum-fromnum))+fromnum;
       int number ;
    String str=null;
       number = (int)(Math.random()*(64-1)+1);
    if(number<10)
    {
     //ת�����ַ���
     
     str = Integer.toString(number);
     str = "0"+number;
     //System.out.println(str);
     return str;
    }
    else{
     
     //System.out.println(Integer.toString(number));
     return Integer.toString(number);
    }
    }
   
   
    public String getShi(){ 
     //������λ ��λ 01-02
       int number ;
       number = (int)(Math.random()*1+1);
    String str=null;
    if(number<10)
    {
     //ת�����ַ���
     
     str = Integer.toString(number);
     str = "0"+number;
     //System.out.println(str);
     return str;
    }
    else{
     
     //System.out.println(Integer.toString(number));
     return Integer.toString(number);
    }
          }  
  
   
     public String getXian(){
     //������λ  ��λ  01-05
    int number ;
       number = (int)(Math.random()*4+1);
    String str=null;
    if(number<10)
    {
     //ת�����ַ���
     
     str = Integer.toString(number);
     str = "0"+number;
     //System.out.println(str);
     return str;
    }
    else{
     
     //System.out.println(Integer.toString(number));
     return Integer.toString(number);
    }    
        }
   
    public String getYear(){
     //�� 7--10λ   ��ݣ�1970-1990
  int number;
     number = (int)(Math.random()*(1990-1970)+1970);
  String str=null;
  if(number<10)
  {
	   //ת�����ַ���
	   
	   str = Integer.toString(number);
	   str = "0"+number;
	   //System.out.println(str);
	   return str;
  }
  else{
	   
	   //System.out.println(Integer.toString(number));
	   return Integer.toString(number);
  }
    } 
  
    public String getMonth(){
		     //��11 12 λ      �·ݣ�01-12
		  
		  int number ;
		  number = (int)(Math.random()*(12-1)+1);
		  String str=null;
  if(number<10)
  {
	   //ת�����ַ���
	   
	   str = Integer.toString(number);
	   str = "0"+number;
	   //System.out.println(str);
	   return str;
  }
  else{
   
	   //System.out.println(Integer.toString(number));
	   return Integer.toString(number);
  }
    } 
  
 public String getDay(){
     //��13   14 λ    ���ڣ�01-28
  
		  int number ;
		  number = (int)(Math.random()*(28-1)+1);
		  String str=null;
  if(number<10)
  {
		   //ת�����ַ���
		   
		   str = Integer.toString(number);
		   str = "0"+number;
		   //System.out.println(str);
		   return str;
  }
  else{
   
		   //System.out.println(Integer.toString(number));
		   return Integer.toString(number);
  }
  
  
    }
   
    public String getSequence(){
		     //��15  16 λ        ��λ��01-99
		  int number ;
		  number = (int)(Math.random()*(99-1)+1);
		  String str=null;
  if(number<10)
  {
		   //ת�����ַ���
		   
		   str = Integer.toString(number);
		   str = "0"+number;
		   //System.out.println(str);
		   return str;
  }
  else{
   
		   //System.out.println(Integer.toString(number));
		   return Integer.toString(number);
  }
    }
   
    public String getSex(){
	         // ��17 λ  һλ�Ա�0-9
	     int number ;
	     number = (int)(Math.random()*(9-0)+0);
	     return Integer.toString(number);  
    }

    public  String get17ID(){
	     String str=null;
	     str = this.getSheng()+this.getShi()+this.getXian()+ this.getYear()+ this.getMonth()+ this.getDay() + this.getSequence() + this.getSex()  ;
	     return str;
    }
   
    public String getIDCard(){
	     String str=null;
	       str = this.get17ID() ;
	     str = str + this.getVerify(str); 
	     //String test = this.get17ID();
	     //System.out.println("���֤��ǰ17λ��"+test);
	     //System.out.println("���֤�ţ�"+test+this.getVerify(test));
	     return str;
    }

 

public static void main(String[] args){
 
	RandomIdentify card=new RandomIdentify();
		  
		 //String idcard="41011119820316258";//  41112119821028551  41102219841112602  410111452105122564
		//String idcard = card.get17ID();
		 //System.out.println("41124919810612243"+card.getVerify(idcard));
		//System.out.println("���֤�����һλΪ��"+card.getVerify(idcard));
		//System.out.println("���֤�����һλΪ��"+card.getVerify("������֤��ǰ17λ"));
		 //System.out.println("���֤��ǰ17λΪ��"+card.get17ID());
		 System.out.println("���֤��Ϊ��"+card.getIDCard());
		
		}

}