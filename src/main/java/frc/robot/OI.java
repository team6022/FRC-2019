package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.*;

public class OI
{
	// final Joystick Branjoy = new Joystick(0);
	final XboxController Branjoy = new XboxController(0);


	Button XBoxA = new JoystickButton(Branjoy, 1);
	Button XBoxB = new JoystickButton(Branjoy, 2);
	Button XBoxX = new JoystickButton(Branjoy, 3);
	Button XBoxY = new JoystickButton(Branjoy, 4);
	Button XBoxLB = new JoystickButton(Branjoy, 5);
	Button XBoxRB = new JoystickButton(Branjoy, 6);
	Button XBoxBack = new JoystickButton(Branjoy, 7);
	Button XBoxStart = new JoystickButton(Branjoy, 8);

	public XboxController getJoystickBran()
	{
		return Branjoy;
	}

	public OI()
	{

		// velcro piston
		XBoxA.whenPressed(new VelcroPistonsToggle());

		// arms
		XBoxB.whileHeld(new ExtendingArm());
		XBoxB.whenReleased(new ExtendingArmStop());

		// front lift pistons
		XBoxLB.whenPressed(new LiftPistonsActiveFront(true));
		XBoxLB.whenReleased(new LiftPistonsActiveFront(false));

		// back lisft pistons
		XBoxRB.whenPressed(new LiftPistonsBackActive(true));
		XBoxRB.whenReleased(new LiftPistonsBackActive(false));

		// XBoxBack.whileHeld(new VisionAlign());

		// pull ball in
		XBoxBack.whileHeld(new Intake(0.75));
		XBoxBack.whenReleased(new Intake(0.0));

		// shoot ball out
		XBoxStart.whileHeld(new Intake(-1.0));
		XBoxStart.whenReleased(new Intake(0.0));


	}

}
