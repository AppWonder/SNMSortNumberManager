package com.digitalesdesign.util.sortnumbermanager;
//
//  SNMSortNumberManager.java
//  SNMSortNumberManager
//
//  Created by Götz Neumann on 26.02.08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class SNMSortNumberManager {
    private SNMSortNumberItem item;
    private EOEditingContext ec;
    
    public SNMSortNumberManager(SNMSortNumberItem _item){
        item = _item;
        ec = item.editingContext();
    }
    
    public static void rebuildSortNumbering(NSArray<SNMSortNumberItem> sortedArray){
        for(int i = 0; i< sortedArray.count();i++){
            SNMSortNumberItem currentItem = sortedArray.objectAtIndex(i);
            currentItem.setSortNumber(new Integer(i));
            currentItem.editingContext().saveChanges();
        }
    }
    
    
    
    public void moveUpInSortNumberingByOne(){
        if(sortNumberInt()>0){
            moveToSortNumber(sortNumberInt()-1);
        }
    }
    
    public void moveDownInSortNumberingByOne(){
        moveToSortNumber(sortNumberInt()+1);
    }
    
    public void moveToTopOfSortNumbering(){
        moveToSortNumber(0);
    }
    
    /**Repairs und returns sortNumber**/
    public Integer repairSortNumber(){
        Integer repairedSortNumber = new Integer(item.sortedArray().indexOfObject(item));
        item.setSortNumber(repairedSortNumber);
        ec.saveChanges();
        return repairedSortNumber;
    }
    
    public void moveToSortNumber(int sortNumber){
        if(sortNumber>=0&&sortNumber<item.sortedArray().count()){
            NSMutableArray<SNMSortNumberItem> resortedArray = new NSMutableArray<SNMSortNumberItem>(item.sortedArray());
            resortedArray.removeObject(item);
            resortedArray.insertObjectAtIndex(item,sortNumber);
            rebuildSortNumbering(resortedArray);
        }
    }
    
    public void moveToBottomOfSortNumbering(){
        moveToSortNumber(item.sortedArray().count()-1);
    }
    
    public boolean isFirstInSortNumbering(){
        return (item.sortedArray().objectAtIndex(0)==item);
    }
    
    public Integer sortNumber(){
        Integer sortNumber = item.sortNumber();  
        if(sortNumber==null){
            sortNumber =  repairSortNumber();  
        }
        return sortNumber;
    }
    
    public int sortNumberInt(){
        return sortNumber().intValue();   
    }
    
    public boolean isLastInSortNumbering(){
        return (item!=null&&item.sortedArray().lastObject()==item);
    }
    
    public static NSArray<SNMSortNumberItem> sortedSNMSortNumberItems(NSArray<SNMSortNumberItem> items){
        if(items!=null&&items.count()>0){
            NSMutableArray<EOSortOrdering> sort = new NSMutableArray<EOSortOrdering>();
            sort.addObject(EOSortOrdering.sortOrderingWithKey("sortNumber", EOSortOrdering.CompareAscending));
            return EOSortOrdering.sortedArrayUsingKeyOrderArray(items,sort);
        }
        return NSArray.emptyArray();
    }
}
