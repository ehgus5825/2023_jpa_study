package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 상품 저장
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 상품 수정
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity){
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    // 전체 상품 조회
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    // 상품 단건 조회
    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
