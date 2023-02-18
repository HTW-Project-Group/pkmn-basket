package de.htwberlin.port.basket;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import de.htwberlin.core.domain.model.BasketFactory;
import de.htwberlin.core.domain.repository.BasketInMemoryRepository;
import de.htwberlin.core.domain.repository.IBasketRepository;
import de.htwberlin.core.domain.service.BasketService;
import de.htwberlin.core.domain.service.IBasketService;
import de.htwberlin.port.annotation.IntegrationTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@IntegrationTest
class BasketControllerIntegrationTest {

  private static final String USER_ID = "11111111-0000-0000-0000-000000000000";
  private static final String BASKET_ITEM_ID = "10000000-0000-0000-0000-000000000000";

  private MockMvc mvc;

  @MockBean private IBasketService basketService;
  @MockBean private IBasketRepository repository;
  @MockBean private BasketController controller;

  @BeforeEach
  void setUp() {
    // given
    repository = new BasketInMemoryRepository();
    basketService = new BasketService(repository);
    controller = new BasketController(basketService);

    final UUID userId = UUID.fromString(USER_ID);
    var items =
        List.of(
            BasketFactory.simpleBasketItem()
                .id(UUID.fromString(BASKET_ITEM_ID))
                .userId(userId)
                .name("BasketItem")
                .price(139.99)
                .quantity(5)
                .build(),
            BasketFactory.simpleBasketItem().userId(userId).build(),
            BasketFactory.simpleBasketItem().userId(userId).build(),
            BasketFactory.simpleBasketItem().userId(userId).build());
    repository.save(BasketFactory.simpleBasket(userId).items(items).build());

    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void shouldReturnBasketForUserThenStatus200() throws Exception {
    // given + when
    mvc.perform(get("/v1/basket/user/" + USER_ID))

        // then
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.items", hasSize(4)))
        .andExpect(jsonPath("$.items[0].id").value(BASKET_ITEM_ID))
        .andExpect(jsonPath("$.items[0].userId").value(USER_ID))
        .andExpect(jsonPath("$.items[0].name").value("BasketItem"))
        .andExpect(jsonPath("$.items[0].price").value(139.99))
        .andExpect(jsonPath("$.items[0].quantity").value(5));
  }

  @Test
  void shouldReturnBasketItemWithIdThenStatus200() throws Exception {
    // given + when
    mvc.perform(get("/v1/basket/" + BASKET_ITEM_ID))

        // then
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(BASKET_ITEM_ID));
  }
}
