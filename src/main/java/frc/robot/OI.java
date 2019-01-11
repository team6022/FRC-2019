package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.*;

public class OI {
	final Joystick Branjoy = new Joystick(0);
	Button button = new JoystickButton(Branjoy, 1);

	public OI()
	{
		button.whenPressed(new ExampleCommand());
	}

	public Joystick getJoystickBran()
	{
		return Branjoy;
	}
}
