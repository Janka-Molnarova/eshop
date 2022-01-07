package sk.metatim.eshop.service;

import sk.metatim.eshop.dto.GetItemDTO;

import java.util.List;

public interface ItemService {

    public List<GetItemDTO> getFewPiecesInWarehouse(int lessEqualCount);
}
