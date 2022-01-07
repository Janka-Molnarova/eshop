package sk.metatim.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.GetItemDTO;
import sk.metatim.eshop.persistence.item.Item;
import sk.metatim.eshop.persistence.item.ItemRepository;
import sk.metatim.eshop.utils.ItemConverter;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemConverter itemConverter;

    @Override
    public List<GetItemDTO> getFewPiecesInWarehouse(int lessEqualCount) {
        List<Item> entities = itemRepository.findAllByItemCountLessThanEqual(lessEqualCount);
        if (entities != null) {
            return itemConverter.convertEntitiesToDTOList(entities);
        }
        return null;
    }
}
