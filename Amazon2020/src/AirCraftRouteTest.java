import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class AirCraftRouteTest {
	List<PairInt> forwardRouteList;
	List<PairInt> returnRouteList;
	static List<PairInt> result;
	//forwardRouteList.add(new PairInt(1,2000));
//	forwardRouteList.add(new PairInt(2,3000));
//	forwardRouteList.add(new PairInt(3,4000));
//	returnRouteList.add(new PairInt(1,2000));

	@BeforeEach
	void setUp() throws Exception {
		this.forwardRouteList=new ArrayList<PairInt>();
		this.returnRouteList=new ArrayList<PairInt>();
		this.result=new ArrayList<PairInt>();
	}

	@Test
	void testGetOptimizedUtilize() {
	//	fail("Not yet implemented"); // TODO
		forwardRouteList.add(new PairInt(1,2000));
		forwardRouteList.add(new PairInt(2,3000));
		forwardRouteList.add(new PairInt(3,4000));
		returnRouteList.add(new PairInt(1,2000));
		result.add(new PairInt(2,1));
		assertTrue(AirCraftRoute.getOptimizedUtilize(7000, forwardRouteList, returnRouteList)!= result);
		//assertTrue(1==1);
		
	}

	@Test
	void testAircraftUtilization() {
		fail("Not yet implemented"); // TODO
	}

}
