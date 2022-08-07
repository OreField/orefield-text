module.exports = {
    tabWidth: 4,
    parser: "typescript",
    overrides: [
        {
            files: "*.mdx",
            options: {
                parser: "mdx",
            },
        },
    ],
};
