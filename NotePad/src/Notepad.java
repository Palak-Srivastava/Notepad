import java.awt.event.KeyEvent;
//import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.*;
public class Notepad extends JFrame implements ActionListener
{
        JTextArea area;
        JScrollPane pane;
        String texts;

    Notepad()
    {
        setTitle("Notepad");
        setBounds(0,0,1500,950);
        // menubar --> 1
        JMenuBar menubar =new JMenuBar();
// In menubar File --> 2
        JMenu file =new JMenu("File");

//In File , New File -->2a
        JMenuItem newdoc =new JMenuItem("New File");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);

        //In file, open file -->2b
        JMenuItem open =new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);


        //In file, save-->2c
        JMenuItem save =new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);


        //in file, print -->2d
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(this);


        //in file, exit -->2e
        JMenuItem exit =new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        exit.addActionListener(this);


//adding new, save open, print, exit inside file
        file.add(newdoc);
        file.add(open);
        file.add(save); 
        file.add(print);
        file.add(exit);



        JMenu edit =new JMenu("Edit");

//In edit 
        JMenuItem copy =new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(this);

        JMenuItem paste =new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        paste.addActionListener(this);

        JMenuItem cut =new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cut.addActionListener(this);

        JMenuItem selectall =new JMenuItem("SelectAll");
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        selectall.addActionListener(this);

        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);

//In help
        JMenu help =new JMenu("Help");
        JMenuItem about =new JMenuItem("About the Notepad Editor");
        about.addActionListener(this);

        help.add(about);

//adding in menubar files, help, edit
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);

        setJMenuBar(menubar);


        area=new JTextArea();
        area.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        pane =new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane, BorderLayout.CENTER);



    }


    public static void main(String[] args) {
        new Notepad().setVisible(true);

    }


@Override
        public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("New File")) {
                        area.setText("");
                }
                else if(e.getActionCommand().equals("Open")){
                        JFileChooser chooser=new JFileChooser();
                        chooser.setAcceptAllFileFilterUsed(false);
                        FileNameExtensionFilter restrict=new FileNameExtensionFilter("Only .txt files", "txt");
                        chooser.addChoosableFileFilter(restrict);
                        int action=chooser.showOpenDialog(this);
                        if(action!=JFileChooser.APPROVE_OPTION)
                        {
                                return;
                        }
                        File file=chooser.getSelectedFile();
                        try{
                                BufferedReader reader=new BufferedReader(new FileReader(file));
                                area.read(reader, null);

                        }catch(Exception ae)
                        {}


                }
                else if(e.getActionCommand().equals("Save"))
                {
                        JFileChooser saveas=new JFileChooser();
                        saveas.setApproveButtonText("Save");
                        int action=saveas.showOpenDialog(this);
                        if(action!=JFileChooser.APPROVE_OPTION)
                        {
                                return;
                        }
                        File filename=new File(saveas.getSelectedFile()+ ".txt");
                        BufferedWriter outFile=null;
                        try{
                                outFile=new BufferedWriter(new FileWriter(filename));
                                area.write(outFile);
                                

                        }catch(Exception ae){

                        }
                }
                else if(e.getActionCommand().equals("Print"))
                {
                        try
                        {
                            area.print();
                        }catch(Exception ae){

                        }

                }
                else if(e.getActionCommand().equals("Exit")){
                        System.exit(0);
                }
                else if(e.getActionCommand().equals("Copy"))
                {
                        texts=area.getSelectedText();
                }
                else if(e.getActionCommand().equals("Paste"))
                {
                        area.insert(texts,area.getCaretPosition());
                }
                else if(e.getActionCommand().equals("Cut"))
                {
                        texts=area.getSelectedText();
                        area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
                }
                else if(e.getActionCommand().equals("SelectAll"))
                {
                        area.selectAll();
                }
                else if(e.getActionCommand().equals("About the Notepad Editor"))
                {
                        new About().setVisible(true);
                }
                
                
                
        }
}
 