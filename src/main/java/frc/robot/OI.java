package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.*;

public class OI
{
	final Joystick Branjoy = new Joystick(0);

	Button XBoxA = new JoystickButton(Branjoy, 1); // A
	Button XBoxB = new JoystickButton(Branjoy, 2); // B
	Button XBoxX = new JoystickButton(Branjoy, 3); // X
	Button XBoxY = new JoystickButton(Branjoy, 4); // Y
	Button XBoxLB = new JoystickButton(Branjoy, 5); // LB
	Button XBoxRB = new JoystickButton(Branjoy, 6); // RB
	Button XBoxBack = new JoystickButton(Branjoy, 7); // BACK
	Button XBoxStart = new JoystickButton(Branjoy, 8); // START


	public OI()
	{
		XBoxA.whenPressed(new VelcroPistonsToggle());
		XBoxB.whileHeld(new LowerArmSwivel());
		XBoxX.whenPressed(new BackLiftPistonsIn());
		XBoxY.whenPressed(new BackLiftPistonsOut());
		XBoxLB.whenPressed(new FrontLiftPistonsIn());
		XBoxRB.whenPressed(new FrontLiftPistonsOut());

		// XBoxBack.whileHeld(new VisionAlign());
		XBoxBack.whileHeld(new UpperArmSwivel());
		XBoxStart.whileHeld(new Intake());


	}

	public Joystick getJoystickBran()
	{
		return Branjoy;
	}

}
