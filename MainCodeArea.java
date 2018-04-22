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
      String[] s1ar = s1.split("", 0);
      String[] s2ar = s2.split("", 0);
      // String[] s3ar = s3.split("", 0);
      int[][] twoD = new int[s1ar.length+1][s2ar.length+1]; 
      for (int i = 0; i <= s1ar.length ; i++ ) { 
         for (int j = 0; j <= s2ar.length ; j++ ) {
            twoD[i][j] = 0;
         }
      }
      printArrays(twoD,s1ar,s2ar);
      int addThis = 0;
      int rowDec =0;
      int colDec =0;
      int max = 0;
      String sOne ="";
      String sTwo ="";
      for (int row = 1; row <= s1ar.length ; row++ ) { 
         for (int col = 1; col <= s2ar.length ; col++ ) {
            sTwo=s2ar[row-1];
            sOne=s1ar[col-1];
            
            if(sTwo.equals(sOne)){
               addThis = twoD[row-1][col-1];
               twoD[row][col] = addThis+1;
            }
            else{
               rowDec = twoD[row-1][col];
               colDec = twoD[row][col-1];
               max = Math.max(rowDec,colDec);
               twoD[row][col] = max;
            }
         }
      }
      printArrays(twoD,s1ar,s2ar);


   }

   public void printArrays(int[][] ar,String[]s1,String[]s2){
      String output ="          ";
      
      for (int i = 0; i < s1.length ; i++ ) { 
         output += "| "+s1[i] +" |";

      }

      output += "\n";

      for (int i = 0; i < ar.length ; i++ ) { 
         if(i == 0)
         output += "|   |";
         else if(i <= s2.length)
         output += "| "+s2[i-1] +" |";
         else
         output += "     ";
         for (int j = 0; j < ar[0].length ; j++ ) {
            output += "| "+ar[i][j] +" |";
         }
         output+="\n";
      }
      System.out.println(output);

   }
}


         
            