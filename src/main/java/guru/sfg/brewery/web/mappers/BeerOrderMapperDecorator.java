package guru.sfg.brewery.web.mappers;

import guru.sfg.brewery.domain.BeerOrder;
import guru.sfg.brewery.web.model.BeerOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BeerOrderMapperDecorator implements BeerOrderMapper {
    private BeerOrderMapper beerOrderMapper;

    @Autowired
    @Qualifier("delegate")
    public void setBeerOrderMapper(BeerOrderMapper beerOrderMapper) {
        this.beerOrderMapper = beerOrderMapper;
    }

    @Override
    public BeerOrderDto beerOrderToDto(BeerOrder beerOrder) {
        return beerOrderMapper.beerOrderToDto(beerOrder);
    }

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        return beerOrderMapper.dtoToBeerOrder(dto);
    }
}
