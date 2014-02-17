package com.digitalesdesign.util.sortnumbermanager.components;
//
// SNMMoveUpByOne.java: Class file for WO Component 'SNMMoveUpByOne'
// Project SNMSortNumberManager
//
// Created by goetz on 26.02.08
//

import com.digitalesdesign.util.sortnumbermanager.SNMSortNumberItem;
import com.webobjects.foundation.*;
import com.webobjects.appserver.*;
import com.webobjects.eocontrol.*;
import com.webobjects.eoaccess.*;

public class SNMMoveUpByOne extends SNMSortNumberComponent {

    public SNMMoveUpByOne(WOContext context) {
        super(context);
    }

    public SNMSortNumberItem sortNumberItem()
    {
        return (SNMSortNumberItem)valueForBinding("sortNumberItem");
    }
    
    public boolean synchronizesVariablesWithBindings(){
        return false;   
    }
}
