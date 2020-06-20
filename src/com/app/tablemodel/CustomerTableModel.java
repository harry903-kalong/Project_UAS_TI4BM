/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tablemodel;

import com.app.entity.Customers;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahza0
 */
public class CustomerTableModel extends AbstractTableModel{
    private List<Customers> list = new ArrayList<>();
    
    public CustomerTableModel(){}

    public CustomerTableModel(List<Customers> list) {
        this.list = list;
    }
            
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 6) {
            columnIndex += 2;
        }
        return list.get(rowIndex).getValue(columnIndex);
    }

    private String[] headers = {"Customer ID", "Company Name", "Contact Name", "Contact Title","Address", "City", "Country"};
    @Override
    public String getColumnName(int column) {
        return headers[column]; 
    }
    
    
    
}
