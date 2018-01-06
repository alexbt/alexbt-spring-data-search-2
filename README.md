Use as follow:

```
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private ModelJpaRepository modelJpaRepository;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Model> search(@Validated @RequestBody SearchCriteria searchCriteria) {
        Specification<Model> specification = SearchSpecificationBuilder.<Model>builder()
                .add(searchCriteria)
                .build();

        return modelJpaRepository.findAll(specification);
    }

    @RequestMapping(value = "/searches", method = RequestMethod.POST)
    public List<Model> searches(@RequestBody List<SearchCriteria> searchCriterias) {
        Specification<Model> specification = SearchSpecificationBuilder.<Model>builder()
                .add(searchCriterias)
                .build();

        return modelJpaRepository.findAll(specification);
    }
}
```

with payload such as:

```
[
    {
     "operation": "in",
     "key": "value",
     "value": [
        "TEST"
     ]
    },
    {
     "operation": "eq",
     "key": "value",
     "value": "TEST"
    },
    {
     "operation": "between",
     "key": "endDate",
     "start": "1980-08-08",
     "end": "2980-08-08"
    },
    {
     "operation": "ge",
     "key": "subModel.id",
     "value": 1
    },
    {
     "operation": "gt",
     "key": "subModel.id",
     "value": 0
    },
    {
     "operation": "lt",
     "key": "subModel.id",
     "value": 2
    },
    {
     "operation": "le",
     "key": "subModel.id",
     "value": 1
    }
]
```