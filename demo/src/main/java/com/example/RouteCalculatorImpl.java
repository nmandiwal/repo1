package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RouteCalculatorImpl implements RouteCalculator {

	@Value("${file.route}") 
    private String routeFile;
	
	@Override
	public DirectResponse calculateDirectRoute(int depSidInt, int arrSidInt) {
		String depSid = String.valueOf(depSidInt);
		String arrSid = String.valueOf(arrSidInt);
		DirectResponse directResponse = new DirectResponse();

		ClassLoader classLoader = getClass().getClassLoader();
		String pathStr = classLoader.getResource(routeFile).getPath().replaceFirst("^/(.:/)", "$1");
		Path path = Paths.get(pathStr);

		try (Stream<String> lines = Files.lines(path)) {
			Optional<String> routeLine = lines.skip(1)
											  .filter(a -> {
												  	List<String> route = Arrays.asList(a.split(" "));
												  	return (route.indexOf(depSid) > 0 && route.indexOf(arrSid) > route.indexOf(depSid));
											  		})
											  .findAny();

			directResponse.setArrSid(arrSidInt);
			directResponse.setDepSid(depSidInt);
			directResponse.setDirectBusRoute(routeLine.isPresent());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return directResponse;
	}
//	public static void main(String[] args) {
//		RouteCalculatorImpl calculatorImpl = new RouteCalculatorImpl();
//		calculatorImpl.calculateDirectRoute(1, 3);
//	}
}
