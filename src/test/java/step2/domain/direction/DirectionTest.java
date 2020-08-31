package step2.domain.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Coordinate;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

	@DisplayName("방향에 따라 다음 가로축의 좌표를 제대로 찾아오는지 테스트")
	@ParameterizedTest
	@MethodSource("provide")
	void getNextCoordinate(Direction direction, Coordinate result) {
		Coordinate start = new Coordinate(1);
		assertThat(direction.getNextCoordinate(start)).isEqualTo(result);
	}

	static Stream<Arguments> provide() {
		return Stream.of(
				Arguments.of(Direction.RIGHT, new Coordinate(2)),
				Arguments.of(Direction.LEFT, new Coordinate(0)),
				Arguments.of(Direction.DOWN, new Coordinate(1))
		);
	}
}
