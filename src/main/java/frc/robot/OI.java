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

		// velcro piston
		XBoxA.whenPressed(new VelcroPistonsToggle());

		// arms
		XBoxB.whileHeld(new LowerArmSwivel());
		XBoxB.whenReleased(new LowerArmStop());

		// lift pistons
		//in
		// XBoxX.whenPressed(new BackLiftPistonsIn());
		// XBoxLB.whenPressed(new FrontLiftPistonsIn());
		//out
		// XBoxY.whenPressed(new BackLiftPistonsOut());
		// XBoxRB.whenPressed(new FrontLiftPistonsOut());

		XBoxLB.whenPressed(new FrontLiftPistonsIn());
		XBoxLB.whenReleased(new FrontLiftPistonsOut());
		XBoxRB.whenPressed(new BackLiftPistonsIn());
		XBoxRB.whenReleased(new BackLiftPistonsOut());

		// XBoxBack.whileHeld(new VisionAlign());

		// pull ball in
		XBoxBack.whileHeld(new Intake(0.75));
		XBoxBack.whenReleased(new Intake(0.0));

		// shoot ball out
		XBoxStart.whileHeld(new Intake(-0.75));
		XBoxStart.whenReleased(new Intake(0.0));


	}

	public Joystick getJoystickBran()
	{
		return Branjoy;
	}

}
