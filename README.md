
# GenericAdapter for Android RecyclerView

The **GenericAdapter** is a flexible and reusable Android RecyclerView adapter that simplifies the process of creating adapters for various data types. It offers ViewBinding integration, efficient data updates with DiffUtil, and filtering support.

## Features

- **Flexibility**: Create RecyclerView adapters for different data types with ease.
- **ViewBinding Integration**: Utilize ViewBinding for type-safe and efficient view management.
- **Efficient Data Updates**: Benefit from DiffUtil integration for optimized data updates and animations.
- **Filtering Support**: Easily add filtering functionality to your adapters.
- **Customizable**: Customize your adapters by defining your own data binding logic and layouts.

## Usage

1. **Extend the `GenericAdapter` class**: Create your custom adapter by extending `GenericAdapter`. Implement the required methods, including `onBindData` and `createViewBinding`, to specify how your data is displayed.

2. **Integrate ViewBinding**: Utilize ViewBinding to bind your layout's views efficiently.

3. **Submit Data**: Use `submitFilterableList` to submit your data to the adapter. The data will be automatically filtered when needed.

4. **Filtering**: Access the `filter` property to perform filtering operations on your data.

```kotlin
// Example usage:
val adapter = MyAdapter(MyDiffCallback())
adapter.submitFilterableList(dataList)
adapter.filter.filter("searchQuery")
```

## Example

Here's an example of how to create an adapter using the `GenericAdapter`:

```kotlin
class MyAdapter(diffUtil: DiffUtil.ItemCallback<MyData>) :
    GenericAdapter<MyData, MyItemBinding>(diffUtil) {

    override val filter: Filter
        get() = MyFilter()

    override fun createViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): MyItemBinding {
        return MyItemBinding.inflate(inflater, parent, false)
    }

    override fun onBindData(binding: MyItemBinding, item: MyData) {
        // Bind your data to the ViewBinding here
        // Example: binding.textView.text = item.name
    }
}
```

## Contribution

Contributions, issues, and feature requests are welcome! Feel free to open a pull request or create an issue if you have any suggestions or improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
## Copyright

© 2023 Bishal Adhikari. All rights reserved.

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


---

Feel free to customize this `README.md` with more specific information about your project, including installation instructions, advanced usage examples, and license details.
