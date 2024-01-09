
// importing all the needed libiries

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.event.*;
      

public class MovieReservationFinal {

      // varibles declaration
    
    private JFrame Frame1, Frame2A, Frame2B, Frame3, Frame4, Frame5, ReviewsFrame;
    private JLabel nextButtonLabel, greetingLabel, selection, snackLabel, WelcomBack, userINFO, costLabel, GoodBye, Lastly;
    private JTextField usernameField, accountNameField, passwordField, ticketField, selectedMovie, choiceField, FileName, Finish, UserReview, pastReviews;
    private JButton Openingbutton, SignUpButton, nextButton, MyCheckout, submitButton, Checkout, Exit, Review, Cancel, Submit;
    private JList movieList;
    private JScrollPane scrollPane;
    private JPanel MoviePanel, selectedMoviePanel, ButtonsPanel;
    private JRadioButton[] snackRadioButtons;
    private int Width = 500, Height = 500, packageCost = 30;
    // width and hight will be used to set the size for all frames, package cost will be used in frame 3 , this is the base value for it 
    private String UserID, MovieChoise, selectedSnack, ChosenSnack, packageName = "Regular" ;
    // packageName will be used in frame 3 , this is the base value for it unless changed
    

    public MovieReservationFinal() {
        
        // inside the constructor wil be basic settings for each frame and then a call for the needed function to add the components 
        
        // Frame 1 will hold the greating for the user and will have a JmenuBar tto allo old user's to retrive their recipts
        Frame1 = new JFrame("Movie Reservation Application");
        Frame1.setSize(Width, Height);
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame1.setLocationRelativeTo(null);
        Frame1(); // method for the frame components

        // Frame 2A will hold a sign up form for new users
        Frame2A = new JFrame("Sign Up");
        Frame2A.setSize(Width, Height);
        Frame2A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame2A.setLocationRelativeTo(null);
        Frame2A(); // method for the frame components

        // Frame 3 will hold the movie and package information
        Frame3 = new JFrame("Movie Chooser with Tickets");
        Frame3.setSize(Width, Height);
        Frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame3.setLocationRelativeTo(null);
        Frame3(); // method for the frame components

        // Frame 4 will hold the snacks menue info
        Frame4 = new JFrame("Snack menue");
        Frame4.setSize(300, 300);
        Frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame4.setLocationRelativeTo(null);
        Frame4(); // method for the frame components

        // Frame2B will hold the old' user info
        Frame2B = new JFrame("welcome back, need a receipt ?");
        Frame2B.setSize(Width, Height);
        Frame2B.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame2B.setLocationRelativeTo(null);
        Frame2B(); // method for the frame components

        // Frame 5 will hold the checkout information
        Frame5 = new JFrame("Checkout Window");
        Frame5.setSize(Width, Height);
        Frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame5.setLocationRelativeTo(null);
        Frame5(); // method for the frame components

        // ReviewsFrame will hold's old reviws and enables the user to leave a new one as well
        ReviewsFrame = new JFrame("past reviews");
        ReviewsFrame.setSize(Width, Height);
        ReviewsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ReviewsFrame.setLocationRelativeTo(null);
        ReviewsFrame(); // method for the frame components

        Frame1.setVisible(true);

    }

    // Frame1 jMenuBar listeners
    private class menueListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            String menuItemText = menuItem.getText();

            if (menuItemText.equals("Exit")) {
                System.exit(0);
            } else if (menuItemText.equals("see Recipit")) {
                Frame1.dispose();
                Frame2B.setVisible(true);
            }
        }
    }

    // general button listeners 
    private class BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Openingbutton) {
                Frame1.dispose();
                Frame2A.setVisible(true);
            }

            if (e.getSource() == SignUpButton) {
                // Validate the user input

                UserID = usernameField.getText();
                String accountName = accountNameField.getText();
                String password = new String(passwordField.getText());

                if (UserID.isEmpty()) { // to not allow the user to leave the name feild empty
                    JOptionPane.showMessageDialog(null, "Please enter a username.");
                    return;
                }

                if (accountName.isEmpty()) {// to not allow the user to leave the account feild empty
                    JOptionPane.showMessageDialog(null, "Please enter an account name.");
                    return;
                }

                if (password.length() < 8) { // to not allow the user to leave the password feild empty
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
                    return;
                } else {
                    Frame2A.dispose();
                    Frame3.setVisible(true);
                }
            }

        }

    }
    
    // greeting frame 
    private void Frame1() {

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Help?");
        menu.setForeground(Color.DARK_GRAY);
        menuBar.setBackground(Color.LIGHT_GRAY);// styling settings
        menuBar.add(menu);

        JMenuItem menuItemOpenFrame2 = new JMenuItem("Exit");
        menuItemOpenFrame2.addActionListener(new menueListener());
        menu.add(menuItemOpenFrame2);
        JMenuItem menuItemOpenFrame3 = new JMenuItem("see Recipit");
        menuItemOpenFrame3.addActionListener(new menueListener()); // activiting the menuItem by adding an action listener
        menu.add(menuItemOpenFrame3);

        Frame1.setJMenuBar(menuBar);

        // Create the middle label
        JLabel middleLabel = new JLabel(" to a new fast and seamless experince with cinema");
        middleLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));// styling settings
        middleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        middleLabel.setVerticalAlignment(SwingConstants.CENTER);// styling settings

        // Create the north label
        JLabel northLabel = new JLabel("Hello and welcome ");
        northLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the button
        Openingbutton = new JButton("next");
        JLabel buttonLabel = new JLabel("press to sign up:");
        buttonLabel.setForeground(Color.DARK_GRAY);
        buttonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        Openingbutton.addActionListener(new BtnListener());
        Openingbutton.setBackground(Color.DARK_GRAY);
        Openingbutton.setForeground(Color.WHITE);
        // Create a panel for the button and its label
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonLabel);
        buttonPanel.add(Openingbutton);
        buttonPanel.setBackground(Color.LIGHT_GRAY);
     
        // Load an image for Frame 1 
        ImageIcon imageIcon = new ImageIcon("C:/Users/under/OneDrive/Documents/NetBeansProjects/Movie/src/CinamaINTRO.gif");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setSize(200, 200);
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setSize(200, 200);
        Frame1.getContentPane().setLayout(new GridLayout(4, 1));

        // Add the labels and button panel to the frame
        Frame1.getContentPane().add(northLabel);
        Frame1.getContentPane().add(middleLabel);
        Frame1.getContentPane().add(imagePanel);
        Frame1.getContentPane().add(buttonPanel);
        Frame1.getContentPane().setBackground(Color.LIGHT_GRAY);
        // frame one done
    }

    // sign up form for new users
    private void Frame2A() {
        
        // Create the greeting label
        greetingLabel = new JLabel("Welcome to our Sign Up Form!");
        greetingLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));// styling settings

        // Create the username field
        usernameField = new JTextField(20);
        usernameField.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        usernameField.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing

        usernameField.setBorder(BorderFactory.createTitledBorder("Username")); // surronding our feilds with a border 

        // Create the account name field
        accountNameField = new JTextField(20);
        accountNameField.setBorder(BorderFactory.createTitledBorder("Account Name"));
        accountNameField.setMaximumSize(new Dimension(100, 25));
        accountNameField.setMinimumSize(new Dimension(100, 25));

        // Create the password field
        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(100, 25));
        passwordField.setMinimumSize(new Dimension(100, 25));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        // Create the next button
        SignUpButton = new JButton("Next");
        SignUpButton.setBackground(Color.LIGHT_GRAY);
        SignUpButton.setForeground(Color.DARK_GRAY);
        SignUpButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));// styling settings
        SignUpButton.addActionListener(new BtnListener()); // adding an action listener to our button
        nextButtonLabel = new JLabel("Click Next to Proceed:");
        nextButtonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));// styling settings

        // Create a panel for the button and its label
        JPanel SignUpButtonPanel = new JPanel(new FlowLayout());
        SignUpButtonPanel.add(nextButtonLabel); // adding the buttons to the panel
        SignUpButtonPanel.add(SignUpButton);
        SignUpButtonPanel.setBackground(Color.LIGHT_GRAY);

        JPanel JTextsPanel = new JPanel();
        JTextsPanel.setLayout(new BoxLayout(JTextsPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment

        JTextsPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        JTextsPanel.add(greetingLabel);
        JTextsPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        JTextsPanel.add(usernameField);
        JTextsPanel.add(Box.createVerticalStrut(20));
        JTextsPanel.add(accountNameField);
        JTextsPanel.add(Box.createVerticalStrut(20));
        JTextsPanel.add(passwordField);
        JTextsPanel.add(Box.createVerticalStrut(25)); // Add vertical spacing 
        JTextsPanel.add(SignUpButtonPanel);

        // Add the labels, text fields, and button panel to the frame
        Frame2A.getContentPane().setLayout(new BorderLayout());
        Frame2A.getContentPane().add(JTextsPanel, BorderLayout.CENTER);
        Frame2A.getContentPane().setBackground(Color.LIGHT_GRAY);
        JTextsPanel.setBackground(Color.LIGHT_GRAY);

        Frame2A.pack();

        ///// Frame 2A end
    }

    // Frame 2B retriving info about old users
    private void Frame2B() {
        WelcomBack = new JLabel("welcome back !"); // greeting label
        WelcomBack.setFont(new Font("Times New Roman", Font.PLAIN, 12)); // styling settings
        WelcomBack.setHorizontalAlignment(SwingConstants.CENTER);

        userINFO = new JLabel("please enter your user Name so we can retrive your recipt");
        userINFO.setHorizontalAlignment(SwingConstants.CENTER);
        userINFO.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        FileName = new JTextField(10);

        MyCheckout = new JButton("Recipt"); // button to open checkout frame(frame 5)
        MyCheckout.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        MyCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserID = FileName.getText();
                reading();
                Frame2B.dispose();
                Frame5.setVisible(true);

            }
        }); 

        MyCheckout.setHorizontalAlignment(SwingConstants.CENTER);

        Frame2B.setLayout(new GridLayout(4, 1));
        
        // adding the panels to the frame
        Frame2B.add(WelcomBack);
        Frame2B.add(userINFO);
        Frame2B.add(FileName);
        Frame2B.add(MyCheckout);
       
        Frame2B.pack();

        // Frame 2B end
    }

    // Frame 3 , movie and packages choises 
    private void Frame3() {

        Frame3 = new JFrame("Movie Chooser with Tickets");
        Frame3.setSize(Width, Height);
        Frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame3.setLocationRelativeTo(null);

        Frame3.setLayout(new GridLayout(4, 1));

        String[] movies = {"The Shawshank Redemption", "The Godfather", "The Dark Knight", "Pulp Fiction", "The Lord of the Rings: The Return of the King", "Forrest Gump", "Inception", "The Matrix", "Fight Club", "The Good, the Bad and the Ugly"};
        MoviePanel = new JPanel(new BorderLayout()); // Create the list.
        movieList = new JList(movies); // Set the selection mode to single selection. 
        movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        movieList.setVisibleRowCount(5); // Add the list to a scroll pane. 
        scrollPane = new JScrollPane(movieList); // Add the scroll pane to the panel. 
        MoviePanel.add(scrollPane, BorderLayout.CENTER);
        movieList.setBackground(Color.WHITE);
        movieList.setFont(new Font("Times New Roman", Font.BOLD, 15));
        scrollPane.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        scrollPane.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing
        MoviePanel.setBackground(Color.LIGHT_GRAY);
        // get/show the users' tickets 
        JLabel Title = new JLabel("Please Select your Desired movie' details : ");
        Title.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setMaximumSize(new Dimension(30, 25)); // Set maximum size to prevent resizing
        Title.setMinimumSize(new Dimension(30, 25)); // Set minimum size to prevent resizing

        JLabel AmountOfTickets = new JLabel("amount of tickets ");
        AmountOfTickets.setForeground(Color.DARK_GRAY);
        AmountOfTickets.setFont(new Font("Times New Roman", Font.BOLD, 15));
        AmountOfTickets.setHorizontalAlignment(SwingConstants.CENTER);
        AmountOfTickets.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        AmountOfTickets.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing

        JPanel TicketsPanel = new JPanel();

        ticketField = new JTextField(5);
        ticketField.setForeground(Color.DARK_GRAY);
        ticketField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        ticketField.setHorizontalAlignment(SwingConstants.CENTER);
        ticketField.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        ticketField.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing

        TicketsPanel.setBackground(Color.LIGHT_GRAY);
        ticketField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    // Parse the input ticket quantity
                    int tickets = Integer.parseInt(ticketField.getText());
                } catch (NumberFormatException ex) {
                    // Clear the ticket field if invalid input
                    ticketField.setText("");
                }
            }
        });

        // get/show the users' movie
        selectedMoviePanel = new JPanel(); // Create the label.

        selection = new JLabel("You selected: "); // Create the text field.
        selection.setForeground(Color.DARK_GRAY);
        selection.setFont(new Font("Times New Roman", Font.BOLD, 15));
        selection.setHorizontalAlignment(SwingConstants.CENTER);
        selection.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        selection.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing

        selectedMovie = new JTextField(10); // Make the text field uneditable.
        selectedMovie.setForeground(Color.DARK_GRAY);
        selectedMovie.setFont(new Font("Times New Roman", Font.BOLD, 15));
        selectedMovie.setHorizontalAlignment(SwingConstants.CENTER);
        selectedMovie.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        selectedMovie.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing

        selectedMovie.setEditable(false); // Add the label and text field to the panel.

        costLabel = new JLabel("select your prefered package");
        costLabel.setForeground(Color.DARK_GRAY);
        costLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        costLabel.setHorizontalAlignment(SwingConstants.CENTER);
        costLabel.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        costLabel.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing

        String[] packages = {"Premium ($40)", "Gold ($60)", "Regular ($30)"};
        JComboBox<String> packageComboBox = new JComboBox<>(packages);
        packageComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = packageComboBox.getSelectedItem().toString();
                int packageCost = 0;
                if (selectedPackage.equals("Premium ($40)")) {
                    packageCost = 40;
                    packageName = "Premium";
                } else if (selectedPackage.equals("Gold ($60)")) {
                    packageCost = 60;
                    packageName = "Gold";

                } else {
                    packageCost = 30;
                    packageName = "Regular";
                }
                updateCost(packageCost);
            }
        });
        packageComboBox.setForeground(Color.DARK_GRAY);
        packageComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        packageComboBox.setMaximumSize(new Dimension(100, 25)); // Set maximum size to prevent resizing
        packageComboBox.setMinimumSize(new Dimension(100, 25)); // Set minimum size to prevent resizing
        JPanel radios = new JPanel(new GridLayout());
        radios.add(packageComboBox);
        radios.setBackground(Color.LIGHT_GRAY);
       
        // Create a panel to hold the text field.
        selectedMoviePanel.add(selection);
        selectedMoviePanel.add(selectedMovie);
        selectedMoviePanel.setBackground(Color.LIGHT_GRAY);

        MoviePanel.add(selectedMoviePanel, BorderLayout.SOUTH);

        TicketsPanel.setLayout(new FlowLayout());
        TicketsPanel.add(AmountOfTickets);
        TicketsPanel.add(ticketField);

        JPanel lefts = new JPanel(new GridLayout(4, 1));
        JLabel empty = new JLabel("");
        empty.setHorizontalAlignment(SwingConstants.CENTER);
        empty.setMaximumSize(new Dimension(30, 25)); // Set maximum size to prevent resizing
        empty.setMinimumSize(new Dimension(30, 25)); // Set minimum size to prevent resizing

        lefts.add(TicketsPanel);
        lefts.add(empty);
        lefts.add(costLabel);
        lefts.add(radios);

        movieList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               

                if (!e.getValueIsAdjusting()) {
                    String selectedMovie2 = (String) movieList.getSelectedValue();
                    selectedMovie.setText(selectedMovie2);
                }
            }
        });
        lefts.setBackground(Color.LIGHT_GRAY);
        MoviePanel.setBackground(Color.LIGHT_GRAY);

        nextButton = new JButton("Next");
        nextButton.setSize(40, 40);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ListSelectionModel selectionModel = movieList.getSelectionModel();
                if (selectionModel.isSelectionEmpty()) {
                 // The user didn't choose any option from the JList
                 JOptionPane.showMessageDialog(null, "please choose a movie");
                 return;    
                }
                
                MovieChoise = choiceField.getText();
                int tickets = 0;
                try {
                    // Parse the ticket quantity if valid
                    tickets = Integer.parseInt(ticketField.getText());
                } catch (NumberFormatException ex) {
                    // Handle invalid ticket quantity input
                    JOptionPane.showMessageDialog(null, "Please enter a valid number of tickets.");
                    return;
                }

                Frame3.dispose();
                Frame4.setVisible(true);

            }
        });
        nextButton.setBackground(Color.LIGHT_GRAY);
        nextButton.setForeground(Color.DARK_GRAY);
        nextButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        JPanel nextButtonPanel = new JPanel();
        nextButtonPanel.add(nextButton);

        Frame3.add(Title);
        Frame3.add(MoviePanel);
        Frame3.add(lefts);

        Frame3.add(nextButtonPanel);

        Frame3.pack();

        // Frame 3A end
    }

    // Frame 3 methode for the packages cost
    private void updateCost(int cost) {
        costLabel.setText("Cost: $" + cost);
    }

    // snack menu components
    private void Frame4() {

        // Create the snack label
        snackLabel = new JLabel("Please select your snack:");

        // Create the snack radio buttons
        String[] snacks = {"Chips", "Chocolate", "Candy", "Ice cream", "Pretzels", "dried Fruit", "Yogurt", "mango rolls"};
        snackRadioButtons = new JRadioButton[snacks.length];
        ButtonGroup snackButtonGroup = new ButtonGroup();
        for (int i = 0; i < snacks.length; i++) {
            snackRadioButtons[i] = new JRadioButton(snacks[i]);
            snackButtonGroup.add(snackRadioButtons[i]);
            Frame4.add(snackRadioButtons[i]);
        }

        // Create the choice field
        choiceField = new JTextField(20);
        choiceField.setEditable(false);

        // Create the submit button
        ButtonsPanel = new JPanel();
        ButtonsPanel.setBackground(Color.lightGray);
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected snack
                selectedSnack = null;
                for (JRadioButton snackRadioButton : snackRadioButtons) {
                    if (snackRadioButton.isSelected()) {
                        selectedSnack = snackRadioButton.getText();
                        break;
                    }
                }

                // Display the selected snack in the choice field
                if (selectedSnack != null) {
                    choiceField.setText("Your selected snack is: " + selectedSnack);
                }

            }
        });

        Checkout = new JButton("checkout");
        Checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ChosenSnack = choiceField.getText();
                try {
                    writing();
                } catch (ReceiptException ex) {
                 JOptionPane.showMessageDialog(null, "File not created");
                }
                Frame4.dispose();
                reading();
                Frame5.setVisible(true);

            }
        });

        ButtonsPanel.add(submitButton);
        ButtonsPanel.add(Checkout);

        // Add the components to the frame
        Frame4.getContentPane().setLayout(new GridLayout(4,1));
       
        
        JPanel radioPanel = new JPanel(new GridLayout(2, 4));
        
        for (JRadioButton snackRadioButton : snackRadioButtons) {
            radioPanel.add(snackRadioButton);
            snackRadioButton.setFont(new Font("Times New Roman", Font.ITALIC, 11));   }
     
        radioPanel.setBackground(Color.darkGray);
        Frame4.add(snackLabel);
        Frame4.getContentPane().add(radioPanel);
        Frame4.getContentPane().add(choiceField);
        Frame4.getContentPane().add(ButtonsPanel);
        Frame4.getContentPane().setBackground(Color.lightGray);
        Frame4.pack();

       // Frame 4 end
       
    }

    // checkout frame components
    private void Frame5() {

        GoodBye = new JLabel("Thank you for using our program , hope you enjoyed it!");
        GoodBye.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        Finish = new JTextField();
        Finish.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        Finish.setHorizontalAlignment(SwingConstants.CENTER);
        Finish.setEditable(false);
        Finish.setBackground(Color.white);
        Exit = new JButton("EXIT");
        Exit.setForeground(Color.WHITE);
        Exit.setBackground(Color.BLACK);
        Review = new JButton("write a review");
        Review.setForeground(Color.BLACK);
        Review.setBackground(Color.WHITE);

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == Exit) {
                    System.exit(0);
                }
            }
        });

        Review.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Review) {
                    readingReviews();
                    Frame5.dispose();
                    ReviewsFrame.setVisible(true);
                }
            }
        });

        JPanel buttonss = new JPanel();
        buttonss.add(Exit);
        buttonss.add(Review);
        buttonss.setBackground(Color.LIGHT_GRAY);

        Frame5.setLayout(new BorderLayout());
        Frame5.getContentPane().add(GoodBye, BorderLayout.NORTH);
        Frame5.getContentPane().add(Finish, BorderLayout.CENTER);
        Frame5.getContentPane().add(buttonss, BorderLayout.SOUTH);
        Frame5.getContentPane().setBackground(Color.WHITE);

        // Frame 5 end 
    }

    // showing old reviws and enabling the user to write a new one
    private void ReviewsFrame() {

        Lastly = new JLabel("here you can see past customer's reviws and write your own!");
        Lastly.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        Lastly.setBackground(Color.LIGHT_GRAY);
        Lastly.setHorizontalAlignment(SwingConstants.CENTER);
        Lastly.setVerticalAlignment(SwingConstants.CENTER);

        pastReviews = new JTextField();
        pastReviews.setEditable(false);
        pastReviews.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pastReviews.setHorizontalAlignment(SwingConstants.CENTER);
        pastReviews.setBackground(Color.LIGHT_GRAY);
        pastReviews.setHorizontalAlignment(SwingConstants.CENTER);

        UserReview = new JTextField(100);
        UserReview.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        UserReview.setHorizontalAlignment(SwingConstants.CENTER);
        UserReview.setBackground(Color.white);

        Cancel = new JButton("EXIT");
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.BLACK);

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == Cancel) {
                    System.exit(0);
                }

            }
        });

        Submit = new JButton("Submit");
        Submit.setForeground(Color.WHITE);
        Submit.setBackground(Color.BLACK);

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == Submit) {
                    writingReview();
                    System.exit(0);
                }

            }
        });

        JPanel buttonss = new JPanel();
        buttonss.add(Cancel);
        buttonss.add(Submit);
        buttonss.setBackground(Color.LIGHT_GRAY);

        JPanel texts = new JPanel(new GridLayout(2, 1));

        texts.add(pastReviews);
        texts.add(UserReview);
        texts.setBackground(Color.LIGHT_GRAY);

        ImageIcon imageIcon = new ImageIcon("C:/Users/under/OneDrive/Documents/NetBeansProjects/Movie/src/Ending.gif");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setSize(20, 20);
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setSize(20, 20);
        imagePanel.setBackground(Color.LIGHT_GRAY);

        ReviewsFrame.setLayout(new GridLayout(4, 1));
        ReviewsFrame.getContentPane().add(Lastly);
        ReviewsFrame.getContentPane().add(texts);
        ReviewsFrame.getContentPane().add(imagePanel);
        ReviewsFrame.getContentPane().add(buttonss);

        ReviewsFrame.getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    // reading from files for the checkout window
    public void reading() {

        String Name;
        Name = UserID;

        try {

            FileReader fr = new FileReader(Name + ".txt");
            BufferedReader reader = new BufferedReader(fr);
            Finish.read(reader, "file");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "we can't find your file , please try again later");
            System.exit(0);
        }

    }

    // reading into files for the checkout window
    public void writing() throws ReceiptException {
        String Name;
        Name = UserID;
        FileWriter fwriter = null;
        int TK = Integer.parseInt(ticketField.getText());
        TK *= packageCost;

        try {

            fwriter = new FileWriter(Name + ".txt", true);
            PrintWriter outputFile = new PrintWriter(fwriter);
            outputFile.println("" + ChosenSnack + " which costs 10$,");
            outputFile.println("\n your selected movie is " + selectedMovie.getText() + " \nyou got " + ticketField.getText() + " tickets" + " for " + TK + "$" + "your selected package is " + packageName + "\n Thank you for visiting, " + Name + " !");
            fwriter.close();
        } catch (IOException ex) {
            throw new ReceiptException("Error writing the receipt. Please try again.");
            
        }

    }
    
    
    // reading from files for the reviws window
    public void readingReviews() {

        try {

            FileReader fr = new FileReader("Reviws.txt");
            BufferedReader reader = new BufferedReader(fr);
            pastReviews.read(reader, "file");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "our reviews file not avalible");
            System.exit(0);
        }

    }

    // wrriting into files for the reviws window
    public void writingReview() {

        FileWriter fwriter = null;

        try {

            fwriter = new FileWriter("Reviws.txt", true);
            PrintWriter outputFile = new PrintWriter(fwriter);
            outputFile.println("- "+UserReview.getText());
            fwriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "no reviews yet");
        }
    }

    
    // calling for the class to enable it .
    public static void main(String[] args) {
        new MovieReservationFinal();
       
    }


}
