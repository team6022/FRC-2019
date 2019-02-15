package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.*;

public class OI
{
	final Joystick Branjoy = new Joystick(0);
	final Joystick Hank = new Joystick(1);
	Button button1 = new JoystickButton(Branjoy, 1);
	Button button3 = new JoystickButton(Branjoy, 3);
	Button button2 = new JoystickButton(Branjoy, 2);
	Button button4 = new JoystickButton(Branjoy, 4);
	Button button5 = new JoystickButton(Branjoy, 5);
	Button button6 = new JoystickButton(Branjoy, 6);
	Button button7 = new JoystickButton(Branjoy, 7); // xbox back button

	public OI()
	{
		button1.whenPressed(new VelcroPistonsToggle());
		button2.whenPressed(new LowerArmSwivel());
		button3.whenPressed(new BackLiftPistonsIn());
		button4.whenPressed(new BackLiftPistonsOut());
		button5.whenPressed(new FrontLiftPistonsIn());
		button6.whenPressed(new FrontLiftPistonsOut());
		button7.whileHeld(new VisionAlign());

	}

	public Joystick getJoystickBran()
	{
		return Branjoy;
	}

	public Joystick getJoystickHank()
	{
		return Hank;
	}
}
