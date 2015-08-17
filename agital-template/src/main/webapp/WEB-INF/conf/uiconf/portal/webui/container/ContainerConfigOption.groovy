/**
 * Copyright (C) 2009 eXo Platform SAS.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

import org.exoplatform.webui.core.model.SelectItemCategory ;
import org.exoplatform.webui.core.model.SelectItemOption ;
  
  List templates = new ArrayList() ;
  
  SelectItemCategory row = new SelectItemCategory("row") ; 
    row.addSelectItemOption(new SelectItemOption("oneRow",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>",
        "OneRowContainerLayout"));
    
     row.addSelectItemOption(new SelectItemOption("twoRows",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "</container>",
        "TwoRowContainerLayout")) ;
     row.addSelectItemOption(new SelectItemOption("threeRows",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +          
        "</container>",
        "ThreeRowContainerLayout"));
     
     row.addSelectItemOption(new SelectItemOption("pluginContainer",
        "<container template=\"system:/groovy/portal/webui/container/UIAddOnContainer.gtmpl\">" +
        "<name>Dynamic Container</name><factory-id>addonContainer</factory-id>" +
        "</container>",
        "PluginContainerLayout"));
  templates.add(row);
  
  SelectItemCategory column = new SelectItemCategory("column") ;
    column.addSelectItemOption(new SelectItemOption("oneColumns","" +
        "<container template=\"system:/groovy/portal/webui/container/UITableColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>", 
        "OneRowContainerLayout"));
    column.addSelectItemOption(new SelectItemOption("twoColumns",
        "<container template=\"system:/groovy/portal/webui/container/UITableColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>",
        "TwoColumnContainerLayout"));
    column.addSelectItemOption(new SelectItemOption("threeColumns",
        "<container template=\"system:/groovy/portal/webui/container/UITableColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>",
        "ThreeColumnContainerLayout"));
    //responsive container
    column.addSelectItemOption(new SelectItemOption("oneColumnsResponsive","" +
        "<container template=\"system:/groovy/portal/webui/container/UIResponsiveTableColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>", 
        "OneRowResponsiveContainerLayout"));
    column.addSelectItemOption(new SelectItemOption("twoColumnsResponsive",
        "<container template=\"system:/groovy/portal/webui/container/UIResponsiveTableTwoColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>",
        "TwoColumnResponsiveContainerLayout"));
    column.addSelectItemOption(new SelectItemOption("threeColumnsResponsive",
        "<container template=\"system:/groovy/portal/webui/container/UIResponsiveTableThreeColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>",
        "ThreeColumnResponsiveContainerLayout"));

    column.addSelectItemOption(new SelectItemOption("fourColumnsResponsive",
        "<container template=\"system:/groovy/portal/webui/container/UIResponsiveTableFourColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +        
        "</container>",
        "FourColumnResponsiveContainerLayout"));
    
    column.addSelectItemOption(new SelectItemOption("bigSmallResponsive",
        "<container template=\"system:/groovy/portal/webui/container/UIResponsiveTableBigSmallColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +        
        "</container>",
        "BigSmallColumnResponsiveContainerLayout"));
    
    column.addSelectItemOption(new SelectItemOption("smallBigResponsive",
        "<container template=\"system:/groovy/portal/webui/container/UIResponsiveTableSmallBigColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIResponsiveColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +        
        "</container>",
        "SmallBigColumnResponsiveContainerLayout"));    

    column.addSelectItemOption(new SelectItemOption("pluginColumnContainer",
       "<container template=\"system:/groovy/portal/webui/container/UIAddOnColumnContainer.gtmpl\">" +
       "<name>Dynamic Column Container</name><factory-id>addonContainer</factory-id>" +
       "</container>",
       "PluginColumnContainerLayout"));
  templates.add(column);  

  SelectItemCategory autofitColumn = new SelectItemCategory("autofitColumn") ;
    autofitColumn.addSelectItemOption(new SelectItemOption("autofitOneColumns","" +
        "<container template=\"system:/groovy/portal/webui/container/UITableAutofitColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>", 
        "OneRowContainerLayout")) ;
    autofitColumn.addSelectItemOption(new SelectItemOption("autofitTwoColumns",
        "<container template=\"system:/groovy/portal/webui/container/UITableAutofitColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>",
        "TwoColumnContainerLayout")) ;
    autofitColumn.addSelectItemOption(new SelectItemOption("autofitThreeColumns",
        "<container template=\"system:/groovy/portal/webui/container/UITableAutofitColumnContainer.gtmpl\">" +
        "  <factory-id>TableColumnContainer</factory-id>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "</container>",
        "ThreeColumnContainerLayout")) ;
  templates.add(autofitColumn);  
  
  SelectItemCategory tabs = new SelectItemCategory("tabs") ;
    tabs.addSelectItemOption(new SelectItemOption("twoTabs",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
          "<container template=\"system:/groovy/portal/webui/container/UITabContainer.gtmpl\">" +
          "  <factory-id>TabContainer</factory-id>" +
          "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
          "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
          "</container>" +
        "</container>",
        "TwoTabContainerLayout")) ;
    tabs.addSelectItemOption(new SelectItemOption("threeTabs",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
          "<container template=\"system:/groovy/portal/webui/container/UITabContainer.gtmpl\">" +
          "  <factory-id>TabContainer</factory-id>" +
          "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
          "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
          "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
          "</container>" +
        "</container>",
        "ThreeTabContainerLayout")) ;
  templates.add(tabs);  
  
  SelectItemCategory mixed = new SelectItemCategory("mix") ;
    mixed.addSelectItemOption(new SelectItemOption("twoColumnsOneRow",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
        "  <container template=\"system:/groovy/portal/webui/container/UITableColumnContainer.gtmpl\">" +
        "    <factory-id>TableColumnContainer</factory-id>" +
        "    <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "    <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  </container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "</container>",
        "TwoColumnOneRowContainerLayout")) ;
    mixed.addSelectItemOption(new SelectItemOption("oneRowTwoColumns",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UITableColumnContainer.gtmpl\">" +
        "    <factory-id>TableColumnContainer</factory-id>" +
        "    <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "    <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  </container>" +
        "</container>",
        "OneRowTwoColumnContainerLayout")) ;
    mixed.addSelectItemOption(new SelectItemOption("oneRow2Column1Row",
        "<container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\">" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UITableColumnContainer.gtmpl\">" +
        "    <factory-id>TableColumnContainer</factory-id>" +
        "    <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "    <container template=\"system:/groovy/portal/webui/container/UIColumnContainer.gtmpl\"><factory-id>ColumnContainer</factory-id></container>" +
        "  </container>" +
        "  <container template=\"system:/groovy/portal/webui/container/UIContainer.gtmpl\"></container>" +
        "</container>",
        "OneRow2Column1RowContainerLayout")) ;
  templates.add(mixed);

return templates;