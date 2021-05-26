public class Operation{
   static{
	   System.loadLibrary("Operation"); 	 
   }
   public native void greet();
   public static void main(String[] args){
	   Operation test=new Operation();
	   test.greet();
	   }
}
