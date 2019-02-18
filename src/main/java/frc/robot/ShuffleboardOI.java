package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import frc.robot.commands.*;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around
 */
public class ShuffleboardOI
{


	ShuffleboardOI() {

		// Velcro Pistons
		ShuffleboardLayout velcroPistons = Shuffleboard
			.getTab("Commands")
			.getLayout("Velcro Pistons", BuiltInLayouts.kList)
			.withSize(2, 2)
			.withPosition(0, 0);

		velcroPistons.add(new VelcroPistonsToggle());


		// Intake
		ShuffleboardLayout inTake = Shuffleboard
			.getTab("Commands")
			.getLayout("Intake", BuiltInLayouts.kList)
			.withSize(2, 2)
			.withPosition(2, 0);

		inTake.add(new Intake(0.0));


		// Front Lift Piston
		ShuffleboardLayout liftPistons = Shuffleboard
			.getTab("Commands")
			.getLayout("Back and Front Lift Pistons", BuiltInLayouts.kList)
			.withSize(2, 2)
			.withPosition(4, 0);

		liftPistons.add("List Pistons Front In", new LiftPistonsActiveFront(false));
		liftPistons.add("List Pistons Front Out", new LiftPistonsActiveFront(true));

		liftPistons.add("List Pistons Back In", new LiftPistonsBackActive(false));
		liftPistons.add("List Pistons Back Out", new LiftPistonsBackActive(true));

	}

}
