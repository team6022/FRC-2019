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

		// pistons
		XBoxX.whenPressed(new BackLiftPistonsIn());
		XBoxY.whenPressed(new BackLiftPistonsOut());
		XBoxLB.whenPressed(new FrontLiftPistonsIn());
		XBoxRB.whenPressed(new FrontLiftPistonsOut());

		// XBoxBack.whileHeld(new VisionAlign());

		// pull ball in
		XBoxBack.whileHeld(new IntakeRun(0.75));
		XBoxBack.whenReleased(new IntakeRun(0.0));

		// shoot ball out
		XBoxStart.whileHeld(new IntakeRun(-0.75));
		XBoxStart.whenReleased(new IntakeRun(0.0));


	}

	public Joystick getJoystickBran()
	{
		return Branjoy;
	}

}
