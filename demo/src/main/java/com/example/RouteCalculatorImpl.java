package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class RouteCalculatorImpl implements RouteCalculator {

	@Override
	public DirectResponse calculateDirectRoute(int depSidInt, int arrSidInt) {
		String depSid = String.valueOf(depSidInt);
		String arrSid = String.valueOf(arrSidInt);
		Path path = Paths.get("D://routes.txt");
		DirectResponse directResponse = new DirectResponse();
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
}
