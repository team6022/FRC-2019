package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.*;

public class OI {
	final Joystick Branjoy = new Joystick(0);
	Button button1 = new JoystickButton(Branjoy, 1);
	Button button2 = new JoystickButton(Branjoy, 2);

	
	public OI()
	{
		button1.whenPressed(new VelcroPistonsToggle());
		//button2.whenPressed(new VelcroPistonsIn());
	}

	public Joystick getJoystickBran()
	{
		return Branjoy;
	}
}