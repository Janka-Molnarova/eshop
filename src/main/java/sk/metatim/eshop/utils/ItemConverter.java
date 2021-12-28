package sk.metatim.eshop.utils;

import org.springframework.stereotype.Component;
import sk.metatim.eshop.dto.GetItemDTO;
import sk.metatim.eshop.persistence.item.Item;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemConverter {

    public GetItemDTO convertEntityToDTO(Item item) {

        GetItemDTO dto = new GetItemDTO();
        dto.setId(Long.toString(item.getId()));
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setItemCount(item.getItemCount());

        return dto;
    }

    public List<GetItemDTO> convertEntitiesToDTOList(List<Item> items) {
        List<GetItemDTO> dtoList = new ArrayList<>();
        for (Item item: items) {
            dtoList.add(convertEntityToDTO(item));
        }
        return dtoList;
    }
}
