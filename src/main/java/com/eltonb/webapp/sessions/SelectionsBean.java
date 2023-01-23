/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eltonb.webapp.sessions;

/**
 *
 * @author elton.ballhysa
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="selectionsBean")
@SessionScoped
public class SelectionsBean implements Serializable
{
   // map of topics to book titles
   private static final HashMap< String, String > booksMap =
      new HashMap< String, String >();

   // initialize booksMap
   static 
   {
      booksMap.put("java", "Java How to Program");
      booksMap.put("cpp", "C++ How to Program");
      booksMap.put("iphone",
         "iPhone for Programmers: An App-Driven Approach");
      booksMap.put("android",
         "Android for Programmers: An App-Driven Approach");
   } 

   // stores individual user's selections
   private Set< String > selections = new TreeSet< String >();
   private String selection; // stores the current selection
   
   public SelectionsBean() {
   }
   
   // return number of selections
   public int getNumberOfSelections()
   {
      return selections.size();
   } 

   // returns the current selection
   public String getSelection()
   {
      return this.selection;
   }

   // store user's selection
   public void setSelection(String topic)
   {
      String bookTitle = booksMap.get(topic);
      selections.add(bookTitle);
      this.selection = topic;
   }

   // return the Set of selections
   public String[] getSelections()  // selectionsBean.selections
   {
      return selections.toArray(new String[selections.size()]);
   } 
} 
