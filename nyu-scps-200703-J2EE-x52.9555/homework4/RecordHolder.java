// Code 3E
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class RecordHolder
{
    private static final Logger logger = Logger.getLogger(RecordHolder.class);

    private static HashMap records= new HashMap();
    static
    {
        Item value;
        String key;
        logger.info("In RecordHolder static constructor");
        value =new Item("Beethoven","Symphonie no 6","Classical",11.99);
        key =String.valueOf(value.getId());
        records.put(key,value);
        logger.debug("Added to RecordHolder: " + value.toString());

        value =new Item("Mozart","Amadeus","Classical",14.99);
        key =String.valueOf(value.getId());
        records.put(key,value);
        logger.debug("Added to RecordHolder: " + value.toString());

        value=new Item("Dizzy Gillespie","Groovin High","Jazz",10.99);
        key =String.valueOf(value.getId());
        records.put(key,value);
        logger.debug("Added to RecordHolder: " + value.toString());

        value=new Item("John Coltrane","Bags and Trane","Jazz",13.99);
        key =String.valueOf(value.getId());
        records.put(key,value);
        logger.debug("Added to RecordHolder: " + value.toString());
        logger.info("Finished RecordHolder static constructor");

    }
    public static ArrayList getByCategory(String category)
    {
        logger.info("In getByCategory");
        // create a temp list
        ArrayList categorized = new ArrayList();

        //get a collection of all records
        Collection all = RecordHolder.records.values();

        // get the iterator from the collection.
        Iterator iterator = all.iterator();

        //loop through all the items.
        while (iterator.hasNext())
        {
            // get the next item
            Item item = (Item) iterator.next();

            // if the category matches - copy it to the temp collection
            if (item.getCategory().equals(category))
            {
                logger.debug("category: " + category);
                logger.debug("Matched Item: " + item.toString());
                categorized.add(item);
            }
        }
        logger.info("returning: " + categorized.size() + " items");
        return categorized;

    }
    public static Item get(String id)
    {
        logger.info("In get");
        Item i = (Item) records.get(id);
        if (i!=null){
            logger.info("returning item: " + i.toString());
        }
        else{
            logger.info("Item Id: " + id + " not found in RecordHolder");
        }
        return i;
    }
}
