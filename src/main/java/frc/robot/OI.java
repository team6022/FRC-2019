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
	Button button4 = new JoystickButton(Branjoy, 4);

	public OI()
	{
		button1.whenPressed(new VelcroPistonsToggle());
		button3.whenPressed(new LiftPistonsIn());
		button4.whenPressed(new LiftPistonsOut());
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
