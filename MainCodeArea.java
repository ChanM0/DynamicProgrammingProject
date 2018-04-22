import java.io.*;
import java.util.ArrayList;

public class MainCodeArea {

   public MainCodeArea(){
   }

//will read the file and put each line into a String array list
   public void readFile(){
      String line = null;
      ArrayList<String> array = new ArrayList<String>(); 
      try{
         FileReader fileReader = new FileReader("input1.txt");
         BufferedReader bufferedReader = new BufferedReader(fileReader);  
         while( ( line = bufferedReader.readLine() ) != null ){
            //System.out.println(line);
            array.add(line);
         }
      }
      catch(FileNotFoundException exFileNotFound){
         System.out.println("input1.txt cant find");
      }
      catch(IOException exIO){
         System.out.println("cantReadFile");
      }
      breakArray(array);
   }


   
   public void breakArray(ArrayList<String> ar){
      String s1 = ar.get(0);
      String s2 = ar.get(1);
      // String s3 = ar.get(2);
      String[] rowS1 = s1.split("", 0);
      String[] colS2 = s2.split("", 0);
      // String[] s3ar = s3.split("", 0);
      int[][] twoD = new int[rowS1.length+1][colS2.length+1]; 
      for (int i = 0; i <= rowS1.length ; i++ ) { 
         for (int j = 0; j <= colS2.length ; j++ ) {
            twoD[i][j] = 0;
         }
      }
      //printArrays(twoD,rowS1,colS2);
      int addThis = 0;
      int rowDec =0;
      int colDec =0;
      int max = 0;
      String sOne ="";
      String sTwo ="";
      String output ="";
      output += "\nrowS1.length: "+rowS1.length+" colS2.length: "+colS2.length+" \n\n";
      for (int row = 1; row <= rowS1.length ; row++ ) { 
		 for (int col = 1; col <= colS2.length ; col++ ) {
		 	// if((col-1) < colS2.length)
		 	// 	sTwo=colS2[col-1];
		 	// else
		 	// 	break;
		 	// if((row-1) < rowS1.length)
		 	// 	sOne=rowS1[row-1];
		 	// else
		 	// 	break;
		 	
		 	sTwo=colS2[col-1];
		 	sOne=rowS1[row-1];
		 	// sTwo=colS2[row-1];
		 	// sOne=rowS1[col-1];
		    if(sTwo.equals(sOne)){
		    	output += "\n\n\nsTwo: "+ sTwo+ " sOne: "+ sOne+ " \nrow: "+row+" col: "+col+" \nrow-1: "+(row-1)+" col-1: "+(col-1)+"\n\n\n\n";
		        addThis = twoD[row-1][col-1];
		        twoD[row][col] = addThis+1;
		    }
		    else{
		    	output += "\nsTwo: "+ sTwo+ " sOne: "+ sOne+ " \nrow: "+row+" col: "+col+" \nrow-1: "+(row-1)+" col-1: "+(col-1)+"\n\n";
		       rowDec = twoD[row-1][col];
		       colDec = twoD[row][col-1];
		       max = Math.max(rowDec,colDec);
		       twoD[row][col] = max;
		    }
		 }
      }
      
      int sub = twoD[rowS1.length][colS2.length]; 
      printArrays(twoD,rowS1,colS2);
      //System.out.println(output);

      System.out.println("Longest sequence is "+ sub);


   }

   public void printArrays(int[][] ar,String[]rowS1,String[]colS2){
      String output ="          ";
      
      for (int i = 0; i < colS2.length ; i++ ) { 
         output += "| "+colS2[i] +" |";

      }

      output += "\n";

      for (int row = 0; row <= rowS1.length ; row++ ) { 
         if(row == 0)
         output += "     ";
         else if(row <= rowS1.length)
         output += "| "+rowS1[row-1] +" |";
         else
         output += "     ";
         for (int col = 0; col <= colS2.length ; col++ ) {
            output += "| "+ar[row][col] +" |";
         }
         output+="\n";
      }
      System.out.println(output);

   }
}


         
            