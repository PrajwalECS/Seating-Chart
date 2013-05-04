
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;

public class DragAndDropHandler extends TransferHandler {  
	   private final DataFlavor localObjectFlavor = new ActivationDataFlavor(Integer[].class, DataFlavor.javaJVMLocalObjectMimeType, "Integer Row Index");

    public DragAndDropHandler() {  
    }  
  
    @Override  
    public int getSourceActions(JComponent c) {  
        return MOVE;  
    }  
  
    @Override  
    protected Transferable createTransferable(JComponent source) {  
  
    	Integer[] rowcol = new Integer[2];
    	rowcol[0] = ((JTable) source).getSelectedRow();
    	rowcol[1]= ((JTable) source).getSelectedColumn();
        return new DataHandler(rowcol,localObjectFlavor.getMimeType());  
    }  
  
    @Override  
    protected void exportDone(JComponent source, Transferable data, int action) {
    	
    }  
    
    @Override  
    public boolean canImport(TransferSupport support) {
        return true;
    }  
  
    @Override
    public boolean importData(TransferSupport support) {  
        JTable jt = (JTable) support.getComponent();
        try {
        	Integer[] rowcol = (Integer[]) support.getTransferable().getTransferData(localObjectFlavor);
        	swap(jt,rowcol);
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        return super.importData(support);  
    }
    
    
    public static void swap (JTable jt, Integer[] rowcol) {
    	Object temp = jt.getValueAt(rowcol[0], rowcol[1]);
    	Object b = jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());
    	
    	jt.setValueAt(b, rowcol[0], rowcol[1]);
    	jt.setValueAt(temp, jt.getSelectedRow(), jt.getSelectedColumn());
    	
    }
}  