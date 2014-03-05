package com.blstream.myhoard.biz.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.blstream.myhoard.biz.model.MediaDTO;
import com.blstream.myhoard.db.model.MediaDS;

public class MediaMapper {

	public static MediaDS map(MediaDTO mediaDTO) {
		MediaDS mediaDS = new MediaDS();
		mediaDS.setCreatedDate(mediaDTO.getCreatedDate());
		mediaDS.setFile(mediaDTO.getFile());
		mediaDS.setId(Integer.parseInt(mediaDTO.getId()));
		mediaDS.setThumbnail(mediaDTO.getThumbnail());

		return mediaDS;
	}

	public static MediaDTO map(MediaDS mediaDS) {
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setCreatedDate(mediaDS.getCreatedDate());
		mediaDTO.setFile(mediaDS.getFile());
		mediaDTO.setId(String.valueOf(mediaDS.getId()));
		mediaDTO.setThumbnail(mediaDS.getThumbnail());
		// TODO generate media URL
		mediaDTO.setUrl("TODO");
		
		return mediaDTO;
	}

	public static List<MediaDTO> map(List<MediaDS> mediaDSs) {
		List<MediaDTO> mediaDTOs = new ArrayList<MediaDTO>();
		for (MediaDS mediaDS : mediaDSs) {
			mediaDTOs.add(MediaMapper.map(mediaDS));
		}
		return mediaDTOs;
	}
	
	public static Set<MediaDTO> mapToSetDTO(Set<MediaDS> mediaDsSet) {
		Set<MediaDTO> mediaDTOs = new HashSet<MediaDTO>();
		for (MediaDS mediaDS : mediaDsSet) {
			mediaDTOs.add(MediaMapper.map(mediaDS));
		}
		return mediaDTOs;
	}
	
	public static Set<MediaDS> mapToSetDS(Set<MediaDTO> mediaDtoSet) {
		Set<MediaDS> mediaDsSet = new HashSet<MediaDS>();
		for (MediaDTO mediaDTO : mediaDtoSet) {
			mediaDsSet.add(MediaMapper.map(mediaDTO));
		}
		return mediaDsSet;
	}
	

}
