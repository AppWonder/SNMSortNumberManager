package com.digitalesdesign.util.sortnumbermanager.components;
//
//  SNMSortNumberComponent.java
//  SNMSortNumberManager
//
//  Created by Götz Neumann on 26.02.08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//

import com.digitalesdesign.util.sortnumbermanager.SNMSortNumberItem;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public abstract class SNMSortNumberComponent extends WOComponent {
    
    public SNMSortNumberComponent(WOContext context) {
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