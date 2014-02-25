package com.digitalesdesign.util.sortnumbermanager;
//
//  SNMSortNumberItem.java
//  SNMSortNumberManager
//
//  Created by Götz Neumann on 26.02.08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//

/**This interface provides a unified way to deal with Objects that are sorted with a SortOrderingMechanism**/
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public interface SNMSortNumberItem{
    /**retuns a SNMSortNumberManager
    **/
    public SNMSortNumberManager sortNumberManager();
    public Integer sortNumber();
    public NSArray<? extends SNMSortNumberItem> sortedArray();
    public void setSortNumber(Integer value);
    public EOEditingContext editingContext();
}
