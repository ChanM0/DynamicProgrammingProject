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
      printArrays(twoD,rowS1,colS2);
      int diagonal = 0;
      int rowDec =0;
      int colDec =0;
      int max = 0;
      String sOne ="";
      String sTwo ="";
      for (int row = 1; row <= rowS1.length ; row++ ) { 
   		 for (int col = 1; col <= colS2.length ; col++ ) {
   		 	sTwo=colS2[col-1];
   		 	sOne=rowS1[row-1];
   		    if(sTwo.equals(sOne)){
   		        diagonal = twoD[row-1][col-1];
   		        twoD[row][col] = diagonal+1;
   		    }
   		    else{
   		       rowDec = twoD[row-1][col];
   		       colDec = twoD[row][col-1];
   		       max = Math.max(rowDec,colDec);
   		       twoD[row][col] = max;
   		    }
   		 }
      }
      
      int sub = twoD[rowS1.length][colS2.length]; 
      printArrays(twoD,rowS1,colS2);
      System.out.println("Longest sequence is "+ sub);
      findSusequence(twoD,rowS1.length,colS2.length,colS2);
   }

   public void findSusequence(int[][] twoD,int row, int col,String[] colS2){
      int rowDec =0;
      int colDec =0;
      String subSequence = "";
      while(row >= 1 && col >= 1 ){
         rowDec = twoD[row-1][col];
         colDec = twoD[row][col-1];
         if(twoD[row][col-1] == twoD[row-1][col]){
            subSequence+=colS2[col-1];
            col--;
            row--;
            }
         else if(colDec == twoD[row][col]){
            col--;
         }
         else{ //if (rowDec == twoD[row][col]){
            row--;
         }
      }
      String[] subSequenceAr  = subSequence.split("");
      //System.out.println(subSequence);
      subSequence="";
      for(int i = subSequenceAr.length - 1; i >=0; i-- ){
         subSequence+=subSequenceAr[i];
      }
      System.out.println(subSequence);

   }

   public void printArrays(int[][] ar,String[]rowS1,String[]colS2){
      String output ="          ";
      
      for (int i = 0; i < colS2.length ; i++ )
         output += "| "+colS2[i] +" |";

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


         
            