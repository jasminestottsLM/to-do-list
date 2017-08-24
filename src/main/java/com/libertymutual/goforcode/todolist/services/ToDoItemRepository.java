package com.libertymutual.goforcode.todolist.services;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Matchers.anyList;

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
 
    	
    	List<ToDoItem> items = new ArrayList<ToDoItem>();
    	
    	try  (Reader in = new FileReader("to-do-list.csv")) {
				Iterable<CSVRecord> records = null;
    			records = CSVFormat.DEFAULT.parse(in);
    			
    			for (CSVRecord record : records) {
    				ToDoItem item = new ToDoItem();
    				int tempId = Integer.parseInt(record.get(0));
    				item.setId(tempId);
    //				item.setId(Integer.parseInt(record.get(0)));  does the same thing, split above to remind myself what's going on here.
    				item.setText(record.get(1));
    				item.setComplete(Boolean.parseBoolean(record.get(2)));
    				items.add(item);
    				
    			}
    							
				
			} catch (FileNotFoundException e) {
				System.out.println("thing");
			} catch (IOException e) {
				System.out.println("thing");
			}
    			    			  
		 return items;    	 
    	
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
    	    	
    	List<ToDoItem> items = getAll();
    	

		
			for (ToDoItem record : items) {
				if (record.getId() == id) {
					return record;
				}
			}
				
        return null;
    }

    /**
     * Updates the given to-do item in the file.
     * @param item The item to update.
     */
    public void update(ToDoItem item) {
        // Fill this in with something meaningful
    	
    	int nextNewId = 1;
    	
    	List<ToDoItem> items = getAll();
    	
    	List<ToDoItem> newItems = new ArrayList<ToDoItem>();
    	
    	
    	try (FileWriter writer = new FileWriter("to-do-list.csv", false);
                CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {

    	
    	for (ToDoItem record : items) {
    		
    		if (record.getId() == item.getId()) {
    			record.setComplete(true);
    			record.setId(nextNewId);
    		} else {
    			record.setId(nextNewId);	
    		}
    		
    		nextNewId += 1;
    		
    		String[] newRecord =  {Integer.toString(record.getId()), record.getText(), Boolean.toString(record.isComplete())};    
                  
            printer.printRecord(newRecord);
          
    		}  }
                 catch (IOException e) {
                   System.out.println("error thing on create");
               }

    		
    	
    }
}

