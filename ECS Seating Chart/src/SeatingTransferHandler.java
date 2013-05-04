

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;

public class SeatingTransferHandler extends TransferHandler {   
	  
    public SeatingTransferHandler() {   
    }   
  
    @Override  
    public int getSourceActions(JComponent c) {   
        return MOVE;   
    }   
  
    @Override  
    protected Transferable createTransferable(JComponent source) {   
  
        return new StringSelection((String) ((JTable) source).getModel().getValueAt(((JTable) source).getSelectedRow(), ((JTable) source).getSelectedColumn()));   
    }   
  
    @Override  
    protected void exportDone(JComponent source, Transferable data, int action) {   
  
        ((JTable) source).getModel().setValueAt("", ((JTable) source).getSelectedRow(), ((JTable) source).getSelectedColumn());   
  
    }   
  
    @Override  
    public boolean canImport(TransferSupport support) {   
        return true;   
    }   
  
    @Override  
    public boolean importData(TransferSupport support) {   
        JTable jt = (JTable) support.getComponent();   
        try {   
            jt.setValueAt(support.getTransferable().getTransferData(DataFlavor.stringFlavor), jt.getSelectedRow(), jt.getSelectedColumn());   
        } catch (UnsupportedFlavorException ex) {   
        } catch (IOException ex) {   
        }   
        return super.importData(support);   
    }   
}  
