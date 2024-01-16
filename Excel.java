package AhmetBuyukyilmaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class Excel {

    public Excel() {

    }
    public void writeExcel(Parent parent) throws ClassNotFoundException {
        XSSFWorkbook wb = new XSSFWorkbook() ;
        String[] row_heading = {"Child", "Start", "Finish","Score"};
        String[] row_heading2 = {"Question", "True/False", "Time"};
        parent.readParent(parent);
        for(Child aChild : parent.getChilds()){
            XSSFSheet spreadsheet = wb.createSheet( aChild.getName());
            Row row= spreadsheet.createRow(0);

            for (int i=0; i < row_heading.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(row_heading[i]);
            }
            int i=1;
            for(Exam exam: aChild.getExams()) {
                Row dataRow = spreadsheet.createRow(i);
                dataRow.createCell(0).setCellValue(exam.getChildName());
                dataRow.createCell(1).setCellValue(exam.getStartDate());
                dataRow.createCell(2).setCellValue(exam.getFinishDate());
                dataRow.createCell(3).setCellValue(exam.getScore());
                i++;
                Row dataRow3 = spreadsheet.createRow(i);
                for (int j=0; j < row_heading2.length; j++) {
                    Cell cell = dataRow3.createCell(j+1);
                    cell.setCellValue(row_heading2[j]);
                }
                i++;
                for(Question question : exam.getQuestions()){
                    Row dataRow2 = spreadsheet.createRow(i);
                    dataRow2.createCell(1).setCellValue(question.getB()+"x"+ question.getA()+"=" + question.getChildsAnswer());
                    if(question.isTrue()) dataRow2.createCell(2).setCellValue("True");
                    else dataRow2.createCell(2).setCellValue("False");
                    dataRow2.createCell(3).setCellValue(question.getTime());
                    i++;
                }
                i++;
            }
        }
        try{
            FileOutputStream out = new FileOutputStream(new File("Reports.xlsx"));
            wb.write(out);
            out.close();
        }catch(FileNotFoundException e){
            System.out.println("File couldnt found.");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("An error occured during file operation");
            e.printStackTrace();
        }
        System.out.println("Success");
    }
}
