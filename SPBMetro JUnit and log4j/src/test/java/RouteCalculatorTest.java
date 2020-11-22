import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> connect12;
    List<Station> connect23;
    List<Station> connect31;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {

        route = new ArrayList<>();
        stationIndex = new StationIndex();

        stationIndex.addLine(new Line(1, "1-я"));
        stationIndex.addLine(new Line(2, "2-я"));
        stationIndex.addLine(new Line(3, "3-я"));

        stationIndex.addStation(new Station("Звездная", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Рубинштейна", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Думская", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Техноложка", stationIndex.getLine(1)));

        stationIndex.addStation(new Station("Ладожская", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Автово", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Спасская", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Дыбенко", stationIndex.getLine(2)));

        stationIndex.addStation(new Station("Девяткино", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Гостиный двор", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Сенная", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Горьковская", stationIndex.getLine(3)));

        stationIndex.getLine(1).addStation(new Station("Звездная", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Рубинштейна", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Думская", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Техноложка", stationIndex.getLine(1)));

        stationIndex.getLine(2).addStation(new Station("Ладожская", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Автово", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Спасская", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Дыбенко", stationIndex.getLine(2)));

        stationIndex.getLine(3).addStation(new Station("Девяткино", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Гостиный двор", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Сенная", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Горьковская", stationIndex.getLine(3)));

        connect12 = new ArrayList<>();
        connect23 = new ArrayList<>();
        connect31 = new ArrayList<>();

        connect12.add(stationIndex.getStation("Рубинштейна"));
        connect12.add(stationIndex.getStation("Автово"));
        stationIndex.addConnection(connect12);

        connect23.add(stationIndex.getStation("Сенная"));
        connect23.add(stationIndex.getStation("Спасская"));
        stationIndex.addConnection(connect23);

        connect31.add(stationIndex.getStation("Гостиный двор"));
        connect31.add(stationIndex.getStation("Думская"));
        stationIndex.addConnection(connect31);
    }

    public void testCalculateDuration() {

        route.add(stationIndex.getStation("Звездная"));
        route.add(stationIndex.getStation("Рубинштейна"));
        route.add(stationIndex.getStation("Автово"));
        route.add(stationIndex.getStation("Спасская"));
        route.add(stationIndex.getStation("Сенная"));
        route.add(stationIndex.getStation("Горьковская"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute() { // Самый короткий путь

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Ладожская"), stationIndex.getStation("Девяткино"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 13.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() { // Путь по одной линии

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Рубинштейна"), stationIndex.getStation("Техноложка"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine2() {  // Путь по одной линии в обратную сторону от конечной

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Техноложка"), stationIndex.getStation("Думская"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 2.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская"), stationIndex.getStation("Дыбенко"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testIsConnected() {

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская"), stationIndex.getStation("Техноложка"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);
    }

    public void testGetRouteViaConnectedLine() {

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        stationIndex.connections.remove(stationIndex.getStation("Сенная"));
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Сенная"), stationIndex.getStation("Спасская"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {

        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        stationIndex.connections.remove(stationIndex.getStation("Спасская"));
        route = routeCalculator.getShortestRoute(stationIndex.getStation("Ладожская"), stationIndex.getStation("Девяткино"));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
