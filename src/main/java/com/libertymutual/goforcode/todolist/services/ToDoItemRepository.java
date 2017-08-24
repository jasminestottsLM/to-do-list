package com.libertymutual.goforcode.todolist.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.validation.DefaultMessageCodesResolver.Format;

import com.libertymutual.goforcode.todolist.models.ToDoItem;

@Service
public class ToDoItemRepository {

    private int nextId = 1;

    /**
     * Get all the items from the file. 
     * @return A list of the items. If no items exist, returns an empty list.
     */
    public List<ToDoItem> getAll() {
//    	try (Reader in = new FileReader("to-do-list.csv")) {
 //   		CSVParser records = CSVFormat.EXCEL.parse(in);
  //  		for (CSVRecord record: records) {
   // 			String ToDoItem = record.get("items");
   // 			System.out.println(records);
   // 		}
    		
    		
   // 		System.out.println("good to here");
    	// Replace this with something meaningful
       
   // 		} catch (FileNotFoundException e) {
//				System.out.println("File not found");
//			} catch (IOException e) {
	//			System.out.println("IO Exception");
		//	}
    	
    	 return Collections.emptyList();
    	 
    	
    }

    
    /**
     * Assigns a new id to the ToDoItem and saves it to the file.
     * @param item The to-do item to save to the file.
     */
    public void create(ToDoItem item) {
    	 item.setId(nextId);
    	 
         nextId += 1;
    		    	
    	try (FileWriter writer = new FileWriter("to-do-list.csv", true);
                CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {

               		
              String[] record =  {Integer.toString(item.getId()), item.getText(), Boolean.toString(item.isComplete())};
              
              
              printer.printRecord(record);
      
              
           } catch (IOException e) {
               System.out.println("error thing on create");
           }
          
          System.out.println("did the create work?");
          
          }
      
    	
    	// Fill this in with something meaningful
    

    /**
     * Gets a specific ToDoItem by its id.
     * @param id The id of the ToDoItem.
     * @return The ToDoItem with the specified id or null if none is found.
     */
    public ToDoItem getById(int id) {
        // Replace this with something meaningful
   // 	CSVRecord item;
   // 	final List<ToDoItem> items = new ArrayList<CSVRecord>();
   // 	while ((item = this.nextRecord()) != null) {
   // 		items.add(item);
   // 	}
    	
        return null;
    }

    /**
     * Updates the given to-do item in the file.
     * @param item The item to update.
     */
    public void update(ToDoItem item) {
        // Fill this in with something meaningful
    }

}