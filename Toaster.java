import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Class to show tosters in multiplatform
 *
 * @author daniele piras
 *
 */
public class Toaster
{
	// Width of the toster
	private int toasterWidth = 200;

	// Height of the toster
	private int toasterHeight = 43;

	// Step for the toaster
	private int step = 20;

	// Step time
	private int stepTime = 20;

	// Show time
	private int displayTime = 4000;

	// Current number of toaster...
	private int currentNumberOfToaster = 0;

	// Last opened toaster
	private int maxToaster = 0;

	// Max number of toasters for the sceen
	private int maxToasterInSceen;

	// Font used to display message
	private Font font;

	// Color for border
	private Color borderColor;

	// Color for toaster
	private Color toasterColor;

	// Set message color
	private Color messageColor;
	
	private int x ;
	private int starty,stopy ;
	// Set the margin
	int margin;

	// Flag that indicate if use alwaysOnTop or not.
	// method always on top start only SINCE JDK 5 !
	boolean useAlwaysOnTop = true;

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor to initialized toaster component...
	 *
	 * @author daniele piras
	 *
	 */
	public Toaster(int xpos, int ypos1)
	{
		// Set default font...
		font = new Font("Arial", Font.BOLD, 12);
		// Border color
		borderColor = new Color(245, 153, 15);
		toasterColor = Color.WHITE;
		messageColor = Color.BLACK;
		useAlwaysOnTop = true;
		// Verify AlwaysOnTop Flag...
		x = xpos;
		starty = ypos1;
		stopy = ypos1;
		try
		{
			JWindow.class.getMethod( "setAlwaysOnTop", new Class[] { Boolean.class } );
		}
		catch( Exception e )
		{
			useAlwaysOnTop = false;
		}

	}

	/**
	 * Class that rappresent a single toaster
	 *
	 * @author daniele piras
	 *
	 */
	class SingleToaster extends javax.swing.JWindow
	{
		private static final long serialVersionUID = 1L;

		// Label to store Icon
		private JLabel iconLabel = new JLabel();

		// Text area for the message
		private JTextArea message = new JTextArea();




		/***
		 * Simple costructor that initialized components...
		 */
		public SingleToaster()
		{
			initComponents();
		}

		/***
		 * Function to initialized components
		 */
		private void initComponents()
		{

			setSize(toasterWidth, toasterHeight);
			message.setFont( getToasterMessageFont() );
			JPanel externalPanel = new JPanel(new BorderLayout(1, 1));
			externalPanel.setBackground( getBorderColor() );
			JPanel innerPanel = new JPanel(new BorderLayout( getMargin(), getMargin() ));
			innerPanel.setBackground( getToasterColor() );
			message.setBackground( getToasterColor() );
			message.setMargin( new Insets( 2,2,2,2 ) );
			message.setLineWrap( true );
			message.setWrapStyleWord( true );

			EtchedBorder etchedBorder = (EtchedBorder) BorderFactory
					.createEtchedBorder();
			externalPanel.setBorder(etchedBorder);

			externalPanel.add(innerPanel);
			message.setForeground( getMessageColor() );
			innerPanel.add(iconLabel, BorderLayout.WEST);
			innerPanel.add(message, BorderLayout.CENTER);
			getContentPane().add(externalPanel);
		}


		/***
		 * Start toaster animation...
		 */
		public void animate()
		{
			( new Animation( this ) ).start();
		}

	}

	/***
	 * Class that manage the animation
	 */
	class Animation extends Thread
	{
		SingleToaster toaster;

		public Animation( SingleToaster toaster )
		{
			this.toaster = toaster;
		}


		/**
		 * Animate vertically the toaster. The toaster could be moved from bottom
		 * to upper or to upper to bottom
		 * @param posx
		 * @param fromy
		 * @param toy
		 * @throws InterruptedException
		 */
		protected void animateVertically( int posx, int fromY, int toY ) throws InterruptedException
		{
			System.out.println(posx+" " + fromY+" " + toY);
			toaster.setLocation( posx, fromY );
			if ( toY < fromY )
			{
				for (int i = fromY; i > toY; i -= step)
				{
					toaster.setLocation(posx, i);
					Thread.sleep(stepTime);
				}
			}
			else
			{
				for (int i = fromY; i < toY; i += step)
				{
					toaster.setLocation(posx, i);
					Thread.sleep(stepTime);
				}
			}
			toaster.setLocation( posx, toY );
		}

		public void run()
		{
			try
			{
				boolean animateFromBottom = true;
				GraphicsEnvironment ge = GraphicsEnvironment
						.getLocalGraphicsEnvironment();
				Rectangle screenRect = ge.getMaximumWindowBounds();

				int screenHeight = (int) screenRect.height;

				int startYPosition;
				int stopYPosition;

				if ( screenRect.y > 0 )
				{
					animateFromBottom = false; // Animate from top!
				}

				maxToasterInSceen = screenHeight / toasterHeight;


				//int posx = (int) screenRect.width - toasterWidth - 1;
				int posx = x;
				
				toaster.setLocation(posx, screenHeight);
				toaster.setVisible(true);
				if ( useAlwaysOnTop )
				{
					toaster.setAlwaysOnTop(true);
				}

				if ( animateFromBottom )
				{
					startYPosition = screenHeight;
					stopYPosition = startYPosition - toasterHeight - 1;
					if ( currentNumberOfToaster > 0 )
					{
						stopYPosition = stopYPosition - ( maxToaster % maxToasterInSceen * toasterHeight );
					}
					else
					{
						maxToaster = 0;
					}
				}
				else
				{
					startYPosition = screenRect.y - toasterHeight;
					stopYPosition = screenRect.y;

					if ( currentNumberOfToaster > 0 )
					{
						stopYPosition = stopYPosition + ( maxToaster % maxToasterInSceen * toasterHeight );
					}
					else
					{
						maxToaster = 0;
					}
				}

				currentNumberOfToaster++;
				maxToaster++;
				startYPosition = starty;
				stopYPosition = stopy ;

				animateVertically( posx, startYPosition, stopYPosition );
				Thread.sleep(displayTime);
				animateVertically( posx, stopYPosition, startYPosition );

				currentNumberOfToaster--;
				toaster.setVisible(false);
				toaster.dispose();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}



	/**
	 * Show a toaster with the specified message and the associated icon.
	 */
	public void showToaster(Icon icon, String msg)
	{
		SingleToaster singleToaster = new SingleToaster();
		if ( icon != null )
		{
			singleToaster.iconLabel.setIcon( icon );
		}
		singleToaster.message.setText( msg );
		singleToaster.animate();
	}

	/**
	 * Show a toaster with the specified message.
	 */
	public void showToaster( String msg )
	{
		showToaster( null, msg );
	}

	/**
	 * @return Returns the font
	 */
	public Font getToasterMessageFont()
	{
		// TODO Auto-generated method stub
		return font;
	}

	/**
	 * Set the font for the message
	 */
	public void setToasterMessageFont( Font f)
	{
		font = f;
	}


	/**
	 * @return Returns the borderColor.
	 */
	public Color getBorderColor()
	{
		return borderColor;
	}



	/**
	 * @param borderColor The borderColor to set.
	 */
	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}



	/**
	 * @return Returns the displayTime.
	 */
	public int getDisplayTime()
	{
		return displayTime;
	}



	/**
	 * @param displayTime The displayTime to set.
	 */
	public void setDisplayTime(int displayTime)
	{
		this.displayTime = displayTime;
	}



	/**
	 * @return Returns the margin.
	 */
	public int getMargin()
	{
		return margin;
	}



	/**
	 * @param margin The margin to set.
	 */
	public void setMargin(int margin)
	{
		this.margin = margin;
	}



	/**
	 * @return Returns the messageColor.
	 */
	public Color getMessageColor()
	{
		return messageColor;
	}



	/**
	 * @param messageColor The messageColor to set.
	 */
	public void setMessageColor(Color messageColor)
	{
		this.messageColor = messageColor;
	}



	/**
	 * @return Returns the step.
	 */
	public int getStep()
	{
		return step;
	}



	/**
	 * @param step The step to set.
	 */
	public void setStep(int step)
	{
		this.step = step;
	}



	/**
	 * @return Returns the stepTime.
	 */
	public int getStepTime()
	{
		return stepTime;
	}



	/**
	 * @param stepTime The stepTime to set.
	 */
	public void setStepTime(int stepTime)
	{
		this.stepTime = stepTime;
	}



	/**
	 * @return Returns the toasterColor.
	 */
	public Color getToasterColor()
	{
		return toasterColor;
	}



	/**
	 * @param toasterColor The toasterColor to set.
	 */
	public void setToasterColor(Color toasterColor)
	{
		this.toasterColor = toasterColor;
	}



	/**
	 * @return Returns the toasterHeight.
	 */
	public int getToasterHeight()
	{
		return toasterHeight;
	}



	/**
	 * @param toasterHeight The toasterHeight to set.
	 */
	public void setToasterHeight(int toasterHeight)
	{
		this.toasterHeight = toasterHeight;
	}



	/**
	 * @return Returns the toasterWidth.
	 */
	public int getToasterWidth()
	{
		return toasterWidth;
	}



	/**
	 * @param toasterWidth The toasterWidth to set.
	 */
	public void setToasterWidth(int toasterWidth)
	{
		this.toasterWidth = toasterWidth;
	}



}