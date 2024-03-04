package nextstep.subway.controller;

import nextstep.subway.dto.path.PathResponse;
import nextstep.subway.dto.path.PathType;
import nextstep.subway.service.PathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paths")
public class PathController {
    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping
    public ResponseEntity<PathResponse> getPaths(
        @RequestParam Long source,
        @RequestParam Long target,
        @RequestParam PathType type
    ) {
        PathResponse response = pathService.getPaths(source, target, type);

        return ResponseEntity
            .ok()
            .body(response);
    }
}
