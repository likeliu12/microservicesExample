package streamLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterBasedOnListField {
	List<Album> albums = new ArrayList<>();
	List<Album> favs = new ArrayList<>();

	void original() {

		for (Album a : albums) {
			boolean hasFavorite = false;
			for (Track t : a.tracks) {
				if (t.rating >= 4) {
					hasFavorite = true;
					break;
				}
			}
			if (hasFavorite)
				favs.add(a);
		}

		Collections.sort(favs, new Comparator<Album>() {
			public int compare(Album a1, Album a2) {
				return a1.name.compareTo(a2.name);
			}
		});
	}

	void convert() {
		favs = albums.stream()
				.filter(a -> a.tracks.stream().anyMatch(t -> t.rating >= 4))
				.sorted((a1, a2) -> a1.name.compareTo(a2.name))
				.collect(Collectors.toList());
	}

	class Track {
		int rating;
	}

	class Album {
		String name;
		List<Track> tracks = new ArrayList<>();

	}
}
