package pandemic.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	
	/*NOTES: All GUI components which might be used (e.g pawns,cards) in other classes will be declared as private fields 
	 * (For now, I'll make everything as fields, will figure out later which ones don't need to be a field)
	 * For clarity's sake, I declared and initialized them at the same time, in one line
	 * (Could also initialize them in constructor but let's keep it this way for now)
	 * */

	/*Content pane which contains all GUI components*/
	private JPanel contentPane;
	
	
	/*Pawn dimensions*/
	private final int[] pawnDims = {30,40}; //{width,height}
	
	/*city size (width)*/
	private final int citySize = 30;
	

	/*Cities - idea: store each city's position (x,y) in itself (label text) (no need to create a new list for positions)  */
		//syntax: city = new JLabel(color,x,y)
	private JLabel blueCity1 = new JLabel("b,566,139");
	private JLabel blueCity2 = new JLabel("b,716,106");
	private JLabel blueCity3 = new JLabel("b,393,248");
	private JLabel blueCity4 = new JLabel("b,435,205");
	private JLabel blueCity5 = new JLabel("b,230,190");
	private JLabel blueCity6 = new JLabel("b,306,190");
	private JLabel blueCity7 = new JLabel("b,328,248");
	private JLabel blueCity8 = new JLabel("b,376,162");
	private JLabel blueCity9 = new JLabel("b,544,228");
	private JLabel blueCity10 = new JLabel("b,630,205");
	private JLabel blueCity11 = new JLabel("b,688,162");
	private JLabel blueCity12 = new JLabel("b,642,106");
	
	private JLabel yellowCity1 = new JLabel("y,376,548");
	private JLabel yellowCity2 = new JLabel("y,716,467");
	private JLabel yellowCity3 = new JLabel("y,364,467");
	private JLabel yellowCity4 = new JLabel("y,508,433");
	private JLabel yellowCity5 = new JLabel("y,285,317");
	private JLabel yellowCity6 = new JLabel("y,352,334");
	private JLabel yellowCity7 = new JLabel("y,435,334");
	private JLabel yellowCity8 = new JLabel("y,393,407");
	private JLabel yellowCity9 = new JLabel("y,468,509");
	private JLabel yellowCity10 = new JLabel("y,605,348");
	private JLabel yellowCity11 = new JLabel("y,666,392");
	private JLabel yellowCity12 = new JLabel("y,716,334");
	
	private JLabel whiteCity1 = new JLabel("w,880,358");
	private JLabel whiteCity2 = new JLabel("w,719,258");
	private JLabel whiteCity3 = new JLabel("w,880,228");
	private JLabel whiteCity4 = new JLabel("w,799,205");
	private JLabel whiteCity5 = new JLabel("w,838,317");
	private JLabel whiteCity6 = new JLabel("w,909,295");
	private JLabel whiteCity7 = new JLabel("w,838,139");
	private JLabel whiteCity8 = new JLabel("w,761,295");
	private JLabel whiteCity9 = new JLabel("w,818,258");
	private JLabel whiteCity10 = new JLabel("w,761,162");
	private JLabel whiteCity11 = new JLabel("w,698,215");
	private JLabel whiteCity12 = new JLabel("w,799,106");
		
	private JLabel redCity1 = new JLabel("r,1125,178");
	private JLabel redCity2 = new JLabel("r,963,433");
	private JLabel redCity3 = new JLabel("r,1072,125");
	private JLabel redCity4 = new JLabel("r,1115,380");
	private JLabel redCity5 = new JLabel("r,1125,248");
	private JLabel redCity6 = new JLabel("r,986,136");
	private JLabel redCity7 = new JLabel("r,986,270");
	private JLabel redCity8 = new JLabel("r,1059,270");
	private JLabel redCity9 = new JLabel("r,986,205");
	private JLabel redCity10 = new JLabel("r,934,337");
	private JLabel redCity11 = new JLabel("r,1026,380");
	private JLabel redCity12 = new JLabel("r,1138,495");
	
	/*cities contains all cities*/
	private ArrayList<JLabel> cities 
	= new ArrayList<JLabel>(Arrays.asList(
			blueCity1,blueCity2,blueCity3,blueCity4,blueCity5,blueCity6,blueCity7,blueCity8,blueCity9,blueCity10,blueCity11,blueCity12,
			yellowCity1,yellowCity2,yellowCity3,yellowCity4,yellowCity5,yellowCity6,yellowCity7,yellowCity8,yellowCity9,yellowCity10,yellowCity11,yellowCity12,
			whiteCity1,whiteCity2,whiteCity3,whiteCity4,whiteCity5,whiteCity6,whiteCity7,whiteCity8,whiteCity9,whiteCity10,whiteCity11,whiteCity12,
			redCity1,redCity2,redCity3,redCity4,redCity5,redCity6,redCity7,redCity8,redCity9,redCity10,redCity11,redCity12
			));
	
	/*Pawns*/
	private JLabel orangePawn = new JLabel();
	private JLabel greenPawn = new JLabel();
	private JLabel bluePawn = new JLabel();
	private JLabel purplePawn = new JLabel();
	
	
	/*PlayerDeck*/
	private JLabel playerDeck = new JLabel(" Player Deck");;
	
	/*InfectionDeck*/
	private JLabel infectionDeck = new JLabel(" Infection Deck");; 
	
	/*PlayerDiscard*/
	private JLabel playerDiscard = new JLabel();
	
	/*InfectionDiscard*/
	private JLabel infectionDiscard = new JLabel();
	
	/*Cards container*/
	private JLabel cardsContainer = new JLabel();
	
	/*Action buttons*/
	private JButton btnDriveFerry = new JButton("Drive");;
	private JButton btnDirectFlight = new JButton("<html>Direct <br> Flight</html>");;
	private JButton btnCharterFlight = new JButton("<html>Charter<br> Flight</html>");
	private JButton btnShuttleFlight = new JButton("<html>Shuttle <br> Flight</html>");;
	private JButton btnBuildResearch = new JButton("<html>Build<br>research</html>");
	private JButton btnTreatDisease = new JButton("<html>Treat <br> Disease</html>");
	private JButton btnShareKnowledge = new JButton("<html>Share<br> Knowledge</html>");
	private JButton btnDiscoverCure = new JButton("<html>Discover <br> a Cure</html>");
	
	/*Actions remaining*/
	private JLabel actionsRemaining = new JLabel("Actions remaining: 4");
	
	/*Cubes remaining indicators*/
	private JLabel redRemaining;
	private JLabel blueRemaining;
	private JLabel yellowRemaining;
	private JLabel purpleRemaining;
	
	/*Player cards*/
	
	/*Infection rate indicator*/
	private JLabel infectionRate;
	
	/*outbreak meter count indicator*/
	private JLabel outbreakMeterCount;
	
	/*Instruction*/
	private JLabel instruction;
	
	
	
	/*ICON/IMAGE PATHS (FINAL FIELDS)*/
	//Including: MAP, pawn icons, city icons, card pics
	
	/*Board Map*/
	private final String boardMapPath = "/pandemic/resources/Map/pandemic9.jpg";
	
	/*Pawn icons*/
	private final String greenPawnIconPath = "/pandemic/resources/Pawns/greenPawn.png";
	private final String bluePawnIconPath = "/pandemic/resources/Pawns/bluePawn.png";
	private final String orangePawnIconPath = "/pandemic/resources/Pawns/orangePawn.png";
	private final String purplePawnIconPath = "/pandemic/resources/Pawns/purplePawn.png";
	
	/*City icons*/
	private final String blueCityIconPath = "/pandemic/resources/Cities/blueCity.png";
	private final String yellowCityIconPath = "/pandemic/resources/Cities/yellowCity.png";
	private final String redCityIconPath = "/pandemic/resources/Cities/redCity.png";
	private final String whiteCityIconPath = "/pandemic/resources/Cities/whiteCity.png";
	
	/*Target icon*/
	private final String targetIconPath = "/pandemic/resources/target.png";
	
	/*Player Deck Picture*/
	private final String playerDeckPicPath = "/pandemic/resources/Deck_Discard/playerDeck.png";

	/*Infection Deck Picture*/
	private final String infectionDeckPicPath = "/pandemic/resources/Deck_Discard/infectionDeck.png";
	
	/*Player Discard Picture*/
	private final String playerDiscardPicPath = "/pandemic/resources/Deck_Discard/playerDisCard.png";
			
	/*Infection Discard Picture*/
	private final String infectionDiscardPicPath = "/pandemic/resources/Deck_Discard/infectionDisCard.png";
	
	/*Top bar icons*/
	private final String outbreakMeterCountIconPath = "/pandemic/resources/TopBar/outbreakSymbol.png";
	private final String infectionRateIconPath = "/pandemic/resources/TopBar/infectionRateSymbol.png";
	private final String instructionIconPath = "/pandemic/resources/TopBar/instructionSymbol.png";
	private final String blueCubesRemPath = "/pandemic/resources/TopBar/blueRem.png";
	private final String redCubesRemPath = "/pandemic/resources/TopBar/redRem.png";
	private final String yellowCubesRemPath = "/pandemic/resources/TopBar/yellowRem.png";
	private final String purpleCubesRemPath = "/pandemic/resources/TopBar/purpleRem.png";
			

	private boolean driveSelected;
	private boolean directFlightSelected;
	private JLabel message;
	private JLabel target = new JLabel();
	private JLabel target2 = new JLabel();
	private JLabel target5 = new JLabel();
	private JLabel target3 = new JLabel();
	private JLabel target4 = new JLabel();

	
	private JLabel lblCard3;
	/*Constructor does 2 things: (1) setting up GUI components (2) create event listener for each component*/
	public GUI() {

		/*This method is responsible for setting up GUI components*/
		initComponents();
		
		/*This method is responsible for creating all the events*/
		createEvents();
		
	}
	
	public JLabel getBluePawn()
	{
		return this.bluePawn;
	}
	
	
	
	private void initComponents() {
		
		/*------Set up JFrame and contentPane-----*/
		setTitle("Pandemic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*----------Set up 8 buttons----------*/
		//Drive Ferry
		//btnDriveFerry.setIcon(new ImageIcon(GUI.class.getResource("/pandemic/resources/icon.png")));
		btnDriveFerry.setBounds(11, 370, 90, 40);
		btnDriveFerry.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnDriveFerry);
		
		//Direct Flight
		//btnDirectFlight.setIcon(new ImageIcon(GUI.class.getResource("/pandemic/resources/icon.png")));
		btnDirectFlight.setBounds(97, 370, 90, 40);
		btnDirectFlight.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnDirectFlight);
		
		//Charter Flight
		btnCharterFlight.setBounds(11, 407, 90, 40);
		btnCharterFlight.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnCharterFlight);
		
		//Shuttle Flight
		btnShuttleFlight.setBounds(97, 407, 90, 40);
		btnShuttleFlight.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnShuttleFlight);

		//Treat Disease
		btnTreatDisease.setBounds(97, 445, 90, 40);
		btnTreatDisease.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnTreatDisease);
		
		//Discover Cure
		btnDiscoverCure.setBounds(97, 482, 90, 40);
		btnDiscoverCure.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnDiscoverCure);

		//Build Research
		btnBuildResearch.setBounds(11, 445, 90, 40);
		btnBuildResearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnBuildResearch);
		
		//Share Knowledge
		btnShareKnowledge.setBounds(11, 482, 90, 40);
		btnShareKnowledge.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(btnShareKnowledge);
		
		
		/*-------Set up Actions remaining-------*/
		
		actionsRemaining.setBounds(19, 348, 131, 16);
		contentPane.add(actionsRemaining);
	
		/*----------Set up playerDeck----------*/
		playerDeck.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(playerDeckPicPath))
				.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH)));
		playerDeck.setBounds(7, 56, 100, 130);
		contentPane.add(playerDeck);

		/*----------Set up infectionDeck----------*/
		infectionDeck.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(infectionDeckPicPath))
				.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH)));
		infectionDeck.setBounds(7, 185, 100, 130);
		contentPane.add(infectionDeck);
		
		/*----------Set up playerDiscard----------*/
		playerDiscard.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(playerDiscardPicPath))
				.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH)));
		playerDiscard.setBounds(106, 56, 100, 130);
		contentPane.add(playerDiscard);
		
		/*----------Set up infectionDiscard----------*/
		infectionDiscard.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(infectionDiscardPicPath))
				.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH)));
		infectionDiscard.setBounds(106, 185, 100, 130);
		contentPane.add(infectionDiscard);
		
		
		/*----------Set up top bar ----------*/
		/* (cubes remaining,instruction,outbreak count, infection rate)*/
		
		//top bar panel container
		JPanel topBar = new JPanel();
		topBar.setBackground(Color.BLACK);
		topBar.setBounds(214, 0, 980, 30);
		contentPane.add(topBar);
		topBar.setLayout(null);
		
		//red cubes remaining
		redRemaining = new JLabel("14");
		redRemaining.setBackground(Color.BLACK);
		redRemaining.setForeground(Color.WHITE);
		redRemaining.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(redCubesRemPath)).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		redRemaining.setBounds(286, 6, 48, 16);
		topBar.add(redRemaining);
		redRemaining.setOpaque(true);
		
		//blue cubes remaining
		blueRemaining = new JLabel("19");
		blueRemaining.setBackground(Color.BLACK);
		blueRemaining.setForeground(Color.WHITE);
		blueRemaining.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(blueCubesRemPath)).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		blueRemaining.setBounds(341, 6, 48, 16);
		topBar.add(blueRemaining);
		blueRemaining.setOpaque(true);

		//yellow cubes remaining
		yellowRemaining = new JLabel("16");
		yellowRemaining.setBackground(Color.BLACK);
		yellowRemaining.setForeground(Color.WHITE);
		yellowRemaining.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(yellowCubesRemPath)).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		yellowRemaining.setBounds(396, 6, 48, 16);
		topBar.add(yellowRemaining);
		yellowRemaining.setOpaque(true);
		
		//purple cubes remaining
		purpleRemaining = new JLabel("23");
		purpleRemaining.setBackground(Color.BLACK);
		purpleRemaining.setForeground(Color.WHITE);
		purpleRemaining.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(purpleCubesRemPath)).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
		purpleRemaining.setBounds(451, 6, 48, 16);
		topBar.add(purpleRemaining);
		purpleRemaining.setOpaque(true);
		
		//instruction
		instruction = new JLabel("");
		instruction.setBackground(Color.BLACK);
		instruction.setForeground(Color.WHITE);
		instruction.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(instructionIconPath)).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		instruction.setBounds(616, 6, 48, 16);
		topBar.add(instruction);
		instruction.setOpaque(true);
		
		//infection rate
		infectionRate = new JLabel("2");
		infectionRate.setBackground(Color.BLACK);
		infectionRate.setForeground(Color.WHITE);
		infectionRate.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(infectionRateIconPath)).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		infectionRate.setBounds(506, 6, 48, 16);
		topBar.add(infectionRate);
		infectionRate.setOpaque(true);
	
		//outbreak meter count
		outbreakMeterCount = new JLabel("0");
		outbreakMeterCount.setBackground(Color.BLACK);
		outbreakMeterCount.setForeground(Color.WHITE);
		outbreakMeterCount.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(outbreakMeterCountIconPath)).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		outbreakMeterCount.setBounds(561, 6, 48, 16);
		topBar.add(outbreakMeterCount);
		outbreakMeterCount.setOpaque(true);
		

		/*----------Set up pawns ----------*/
		loadPawns();
		
		/*----------Set up cities ----------*/
		loadCities();
		
		Icon iconTarget = new ImageIcon(new ImageIcon(GUI.class.getResource(targetIconPath))
				.getImage().getScaledInstance(40, 40,  Image.SCALE_SMOOTH));
		/*
		target.setVisible(false);
		System.out.println(blueCity6.getX());
		target.setBounds(blueCity6.getX()-5,blueCity6.getY()-5,40,40);
		target.setIcon(iconTarget);
		contentPane.add(target);
		
		
		target2.setVisible(false);
		target2.setBounds(blueCity3.getX()-5,blueCity3.getY()-5,40,40);
		target2.setIcon(iconTarget);
		contentPane.add(target2);
		
	
		target3.setVisible(false);
		target3.setBounds(redCity2.getX()-5,redCity2.getY()-5,40,40);
		target3.setIcon(iconTarget);
		contentPane.add(target3);
		
		
		target4.setVisible(false);
		target4.setBounds(blueCity2.getX()-5,blueCity2.getY()-5,40,40);
		target4.setIcon(iconTarget);
		contentPane.add(target4);
		
		
		target5.setVisible(false);
		target5.setBounds(yellowCity9.getX()-5,yellowCity9.getY()-5,40,40);
		target5.setIcon(iconTarget);
		contentPane.add(target5);
		

		

	////
		
		/*JLabel lblCard = new JLabel("");
		lblCard.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/pandemic/resources/Miami.png")).getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH)));
		lblCard.setBounds(535, 613, 90, 120);
		
		JLabel lblCard2 = new JLabel("");
		lblCard2.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/pandemic/resources/Tokyo.png")).getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH)));
		
		lblCard2.setBounds(647, 613, 90, 120);
		
		
		lblCard3 = new JLabel("");
		lblCard3.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/pandemic/resources/Moscow.png")).getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH)));
		lblCard3.setBounds(759, 613, 90, 120);
	
		
		contentPane.add(lblCard);
		contentPane.add(lblCard2);
		contentPane.add(lblCard3);
		*/
		
		
		cardsContainer.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/pandemic/resources/cardsContainer.png")).getImage().getScaledInstance(609, 191, Image.SCALE_SMOOTH)));
		
		cardsContainer.setBounds(470, 580, 609, 191);
		contentPane.add(cardsContainer);
		
		
		/*----------Set up board map ----------*/
		loadMap();
		
		//these are for window builder, ignore
		/*createBlueCities();
		createdWhiteCities();
		createRedCities();
		createYellowCities();*/

	}

	private void createEvents() {

		/*Create event listeners for each city*/
		
		for(JLabel city: cities)
		{
			/*Mouse entered, cursor change to pointer*/
			city.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
			     setCursor(cursor);
			}
			/*Mouse exit, pointer to cursor*/
			public void mouseExited(MouseEvent e)
			{
				Cursor cursor = Cursor.getDefaultCursor();
			     setCursor(cursor);
			}
			
			/*When click on city*/
			public void mouseReleased(MouseEvent e)
			{
				bluePawn.setLocation(city.getX(),city.getY()-20);
				/*if(driveSelected)
				{
					target.setVisible(false);
					target2.setVisible(false);
				}
				if(directFlightSelected)
				{
					target3.setVisible(false);
					target4.setVisible(false);
					target5.setVisible(false);
					lblCard3.setLocation(playerDiscard.getX()+5,playerDiscard.getY()+5);
				}*/
			}
		});
		}
		
		/*-------Events for 8 buttons-------*/
		//Drive Ferry button
		btnDriveFerry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driveSelected = true;
				directFlightSelected=false;
				
				target.setVisible(true);
				target2.setVisible(true);
				target3.setVisible(false);
				target4.setVisible(false);
				target5.setVisible(false);
			}
		});
		
		//Direct Flight button
		btnDirectFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				directFlightSelected = true;
				driveSelected = false;
				target3.setVisible(true);
				target4.setVisible(true);
				target5.setVisible(true);
				target.setVisible(false);
				target2.setVisible(false);
			}
		});
		
		
		//Charter Flight button
		btnCharterFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		//Shuttle Flight button
		btnShuttleFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		//Build Research button
		btnBuildResearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		//TreatDisease button
		btnTreatDisease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		//Discover a cure button
		btnDiscoverCure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		//Share Knowledge button
		btnShareKnowledge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	}

	/*Helper method*/
	private int[] getCityPosition(String labelText)
	{
		String X = "", Y = ""; 
		int i = 0;
		for(i=2; i < labelText.length();i++){
			if(labelText.charAt(i) == ',') {i++;break;}
			X += labelText.charAt(i);
		}
		for(int j=i; j < labelText.length();j++) Y += labelText.charAt(j);
		return new int[]{Integer.parseInt(X),Integer.parseInt(Y)};
	}

	Icon blueCityIcon = new ImageIcon((new ImageIcon(GUI.class.getResource(blueCityIconPath)))
			.getImage().getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH));
	Icon redCityIcon = new ImageIcon((new ImageIcon(GUI.class.getResource(redCityIconPath)))
			.getImage().getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH));
	Icon yellowCityIcon = new ImageIcon((new ImageIcon(GUI.class.getResource(yellowCityIconPath)))
			.getImage().getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH));
	Icon whiteCityIcon = new ImageIcon((new ImageIcon(GUI.class.getResource(whiteCityIconPath)))
			.getImage().getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH));
	
	private void loadCities()
	{
		for(JLabel city : cities)
		{
			int x = getCityPosition(city.getText())[0];
			int y= getCityPosition(city.getText())[1];
			city.setBounds(x,y,citySize,citySize);
			switch(city.getText().charAt(0))
			{
				case 'b': city.setIcon(blueCityIcon); break;
				case 'y': city.setIcon(yellowCityIcon); break;
				case 'r': city.setIcon(redCityIcon); break;
				case 'w': city.setIcon(whiteCityIcon); break;
				default:break;
			}
			contentPane.add(city);
		}
	}

	private void loadPawns()
	{
		/*Load blue pawn*/
		bluePawn.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(bluePawnIconPath)).getImage().getScaledInstance(pawnDims[0], pawnDims[1], Image.SCALE_SMOOTH)));
		bluePawn.setBounds(328, 220, pawnDims[0], pawnDims[1]);
		contentPane.add(bluePawn);
		
		/*Load green pawn*/
		greenPawn.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(greenPawnIconPath)).getImage().getScaledInstance(pawnDims[0], pawnDims[1], Image.SCALE_SMOOTH)));
		greenPawn.setBounds(761, 270, pawnDims[0], pawnDims[1]);
		contentPane.add(greenPawn);
		
		/*Load orange pawn*/
		orangePawn.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(orangePawnIconPath)).getImage().getScaledInstance(pawnDims[0], pawnDims[1], Image.SCALE_SMOOTH)));
		orangePawn.setBounds(285, 292, pawnDims[0], pawnDims[1]);
		contentPane.add(orangePawn);
		
		/*Load purple pawn*/
		purplePawn.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(purplePawnIconPath)).getImage().getScaledInstance(pawnDims[0], pawnDims[1], Image.SCALE_SMOOTH)));
		purplePawn.setBounds(291, 292, pawnDims[0], pawnDims[1]);
		contentPane.add(purplePawn);
		
	}
	
	private void loadMap()
	{
		JLabel map = new JLabel();
		map.setBounds(214, 0, 980, 650);
		map.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource(boardMapPath))
				.getImage().getScaledInstance(980, 650,  Image.SCALE_SMOOTH)));
		contentPane.add(map);
	}
	
	//==============================================================================================
	//==============================================================================================
	//==============================================================================================
	//==============================================================================================
	//==============================================================================================
	//==============================================================================================
	//==============================================================================================
	//IGNORE THIS
	private void initializeCities() {/*
	
	System.out.println(cities.get(0));
	cities.add(blueCity1);
	cities.add(blueCity2);
	cities.add(blueCity3);
	cities.add(blueCity4);
	cities.add(blueCity5);
	cities.add(blueCity6);
	cities.add(blueCity7);
	cities.add(blueCity8);
	cities.add(blueCity9);
	cities.add(blueCity10);
	cities.add(blueCity11);
	cities.add(blueCity12);
	cities.add(whiteCity1);
	cities.add(whiteCity2);
	cities.add(whiteCity3);
	cities.add(whiteCity4);
	cities.add(whiteCity5);
	cities.add(whiteCity6);
	cities.add(whiteCity7);
	cities.add(whiteCity8);
	cities.add(whiteCity9);
	cities.add(whiteCity10);
	cities.add(whiteCity11);
	cities.add(whiteCity12);
	cities.add(yellowCity1);
	cities.add(yellowCity2);
	cities.add(yellowCity3);
	cities.add(yellowCity4);
	cities.add(yellowCity5);
	cities.add(yellowCity6);
	cities.add(yellowCity7);
	cities.add(yellowCity8);
	cities.add(yellowCity9);
	cities.add(yellowCity10);
	cities.add(yellowCity11);
	cities.add(yellowCity12);
	cities.add(redCity1);
	cities.add(redCity2);
	cities.add(redCity3);
	cities.add(redCity4);
	cities.add(redCity5);
	cities.add(redCity6);
	cities.add(redCity7);
	cities.add(redCity8);
	cities.add(redCity9);
	cities.add(redCity10);
	cities.add(redCity11);
	cities.add(redCity12);

	
}*/
	

	/*private void createBlueCities() {

		
		ImageIcon iconBlue = new ImageIcon(GUI.class.getResource("/pandemic/resources/" + blueCityIcon));
		Image imageBlue = iconBlue.getImage();
		//Image i = DyeImage.dye(img,new Color(255,0,0,32));
		Image newImageBlue = imageBlue.getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH);
		iconBlue = new ImageIcon(newImageBlue);

		
		
		blueCity1.setBounds(566, 139, citySize, citySize);
		blueCity1.setIcon(iconBlue);
		contentPane.add(blueCity1);
		
		blueCity2.setBounds(716, 106, citySize, citySize);
		blueCity2.setIcon(iconBlue);
		contentPane.add(blueCity2);
		
		blueCity3.setBounds(393, 248, citySize, citySize);
		blueCity3.setIcon(iconBlue);
		contentPane.add(blueCity3);
		
		blueCity4.setBounds(435, 205, citySize, citySize);
		blueCity4.setIcon(iconBlue);
		contentPane.add(blueCity4);
	
		blueCity5.setBounds(230, 190, citySize, citySize);
		blueCity5.setIcon(iconBlue);
		contentPane.add(blueCity5);
		
		blueCity6.setBounds(306, 190, citySize, citySize);
		blueCity6.setIcon(iconBlue);
		contentPane.add(blueCity6);
		
		blueCity7.setBounds(328, 248, citySize, citySize);
		blueCity7.setIcon(iconBlue);
		contentPane.add(blueCity7);
		
		blueCity8.setBounds(376, 162, citySize, citySize);
		blueCity8.setIcon(iconBlue);
		contentPane.add(blueCity8);
		
		blueCity9.setBounds(544, 228, citySize, citySize);
		blueCity9.setIcon(iconBlue);
		contentPane.add(blueCity9);
		
		blueCity10.setBounds(630, 205, citySize, citySize);
		blueCity10.setIcon(iconBlue);
		contentPane.add(blueCity10);
		
		blueCity11.setBounds(688, 162, citySize, citySize);
		blueCity11.setIcon(iconBlue);
		contentPane.add(blueCity11);
		
		blueCity12.setBounds(642, 106, citySize, citySize);
		blueCity12.setIcon(iconBlue);
		contentPane.add(blueCity12);
		
	}

	private void createRedCities() {
		

	
		
		ImageIcon iconRed = new ImageIcon(GUI.class.getResource("/pandemic/resources/RedCity.png"));
		Image imageRed = iconRed.getImage();
		//Image i = DyeImage.dye(img,new Color(255,0,0,32));
		Image newImageRed = imageRed.getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH);
		iconRed = new ImageIcon(newImageRed);
		
		
		redCity1.setBounds(1125, 178, citySize, citySize);
		redCity1.setIcon(iconRed);
		contentPane.add(redCity1);
		
		redCity2.setBounds(963, 433, citySize, citySize);
		redCity2.setIcon(iconRed);
		contentPane.add(redCity2);
		
		redCity3.setBounds(1072, 125, citySize, citySize);
		redCity3.setIcon(iconRed);
		contentPane.add(redCity3);
		
		redCity4.setBounds(1115, 380, citySize, citySize);
		redCity4.setIcon(iconRed);
		contentPane.add(redCity4);
	
		redCity5.setBounds(1125, 248, citySize, citySize);
		redCity5.setIcon(iconRed);
		contentPane.add(redCity5);
		
		redCity6.setBounds(986, 136, citySize, citySize);
		redCity6.setIcon(iconRed);
		contentPane.add(redCity6);
		
		redCity7.setBounds(986, 270, citySize, citySize);
		redCity7.setIcon(iconRed);
		contentPane.add(redCity7);
		
		redCity8.setBounds(1059, 270, citySize, citySize);
		redCity8.setIcon(iconRed);
		contentPane.add(redCity8);
		
		redCity9.setBounds(986, 205, citySize, citySize);
		redCity9.setIcon(iconRed);
		contentPane.add(redCity9);
		
		redCity10.setBounds(934, 337, citySize, citySize);
		redCity10.setIcon(iconRed);
		contentPane.add(redCity10);
		
		redCity11.setBounds(1026, 380, citySize, citySize);
		redCity11.setIcon(iconRed);
		contentPane.add(redCity11);
		
		redCity12.setBounds(1138, 495, citySize, citySize);
		redCity12.setIcon(iconRed);
		contentPane.add(redCity12);
		}
		
		
		
	private void createdWhiteCities() {

		
		ImageIcon iconWhite = new ImageIcon(GUI.class.getResource("/pandemic/resources/WhiteCity.png"));
		Image imageWhite = iconWhite.getImage();
		//Image i = DyeImage.dye(img,new Color(255,0,0,32));
		Image newImageWhite = imageWhite.getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH);
		iconWhite = new ImageIcon(newImageWhite);
		
		
		whiteCity1.setBounds(880, 358, citySize, citySize);
		whiteCity1.setIcon(iconWhite);
		contentPane.add(whiteCity1);
		
		whiteCity2.setBounds(719, 258, citySize, citySize);
		whiteCity2.setIcon(iconWhite);
		contentPane.add(whiteCity2);
		
		whiteCity3.setBounds(880, 228, citySize, citySize);
		whiteCity3.setIcon(iconWhite);
		contentPane.add(whiteCity3);
		
		whiteCity4.setBounds(799, 205, citySize, citySize);
		whiteCity4.setIcon(iconWhite);
		contentPane.add(whiteCity4);
	
		whiteCity5.setBounds(838, 317, citySize, citySize);
		whiteCity5.setIcon(iconWhite);
		contentPane.add(whiteCity5);
		
		whiteCity6.setBounds(909, 295, citySize, citySize);
		whiteCity6.setIcon(iconWhite);
		contentPane.add(whiteCity6);
		
		whiteCity7.setBounds(838, 139, citySize, citySize);
		whiteCity7.setIcon(iconWhite);
		contentPane.add(whiteCity7);
		
		whiteCity8.setBounds(761, 295, citySize, citySize);
		whiteCity8.setIcon(iconWhite);
		contentPane.add(whiteCity8);
		
		whiteCity9.setBounds(818, 258, citySize, citySize);
		whiteCity9.setIcon(iconWhite);
		contentPane.add(whiteCity9);
		
		whiteCity10.setBounds(761, 162, citySize, citySize);
		whiteCity10.setIcon(iconWhite);
		contentPane.add(whiteCity10);
		
		whiteCity11.setBounds(698, 215, citySize, citySize);
		whiteCity11.setIcon(iconWhite);
		contentPane.add(whiteCity11);
		
		whiteCity12.setBounds(799, 106, citySize, citySize);
		whiteCity12.setIcon(iconWhite);
		contentPane.add(whiteCity12);

		
	}
	
	private void createYellowCities()
	{

	
		
		ImageIcon iconYellow = new ImageIcon(GUI.class.getResource("/pandemic/resources/YellowCity1.png"));
		Image imageYellow = iconYellow.getImage();
		//Image i = DyeImage.dye(img,new Color(255,0,0,32));
		Image newImageYellow = imageYellow.getScaledInstance(citySize, citySize,  Image.SCALE_SMOOTH);
		iconYellow = new ImageIcon(newImageYellow);
		
		
		yellowCity1.setBounds(376, 548, citySize, citySize);
		yellowCity1.setIcon(iconYellow);
		contentPane.add(yellowCity1);
		
		yellowCity2.setBounds(716, 467, citySize, citySize);
		yellowCity2.setIcon(iconYellow);
		contentPane.add(yellowCity2);
		
		yellowCity3.setBounds(364, 467, citySize, citySize);
		yellowCity3.setIcon(iconYellow);
		contentPane.add(yellowCity3);
		
		yellowCity4.setBounds(508, 433, citySize, citySize);
		yellowCity4.setIcon(iconYellow);
		contentPane.add(yellowCity4);
	
		yellowCity5.setBounds(285, 317, citySize, citySize);
		yellowCity5.setIcon(iconYellow);
		contentPane.add(yellowCity5);
		
		yellowCity6.setBounds(352, 334, citySize, citySize);
		yellowCity6.setIcon(iconYellow);
		contentPane.add(yellowCity6);
		
		yellowCity7.setBounds(435, 334, citySize, citySize);
		yellowCity7.setIcon(iconYellow);
		contentPane.add(yellowCity7);
		
		yellowCity8.setBounds(393, 407, citySize, citySize);
		yellowCity8.setIcon(iconYellow);
		contentPane.add(yellowCity8);
		
		yellowCity9.setBounds(468, 509, citySize, citySize);
		yellowCity9.setIcon(iconYellow);
		contentPane.add(yellowCity9);
		
		yellowCity10.setBounds(605, 348, citySize, citySize);
		yellowCity10.setIcon(iconYellow);
		contentPane.add(yellowCity10);
		
		yellowCity11.setBounds(666, 392, citySize, citySize);
		yellowCity11.setIcon(iconYellow);
		contentPane.add(yellowCity11);
		
		yellowCity12.setBounds(716, 334, citySize, citySize);
		yellowCity12.setIcon(iconYellow);
		contentPane.add(yellowCity12);

	}*/
}
}