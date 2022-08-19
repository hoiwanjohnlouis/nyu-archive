<?php

function getTextInput($name, $id, $label, $val = '')
{
    $template  = "<label for=\"%s\">%s</label><br />\n";
    $template .= '<input type="text" name="%s" id="%s" value="%s" />';
    return sprintf(
        $template,
        $id,
        $label,
        $name,
        $id,
        $val
    );
}

function getTextAreaInput($name, $id, $label, $val = '')
{
    $template  = "<label for=\"%s\">%s</label><br />\n";
    $template .= '<textarea type="text" name="%s" id="%s">%s</textarea>';
    return sprintf(
        $template,
        $id,
        $label,
        $name,
        $id,
        $val
    );
}

function getFormFieldsHtml($inputs)
{
    $form = "<ul>\n";
    foreach($inputs as $input => $attrs) {
        $field = '';
        switch ($attrs['type']) {
            case 'text':
                $field = getTextInput(
                    $attrs['name'],
                    $attrs['id'],
                    $attrs['label'],
                    $attrs['value']
                );
                break;
            case 'textarea':
                $field = getTextAreaInput(
                    $attrs['name'],
                    $attrs['id'],
                    $attrs['label'],
                    $attrs['value']
                );
                break;
        }

        if ($field) {
            $form .= '<li>' . $field . '</li>' . "\n";
        }
    }
    return '</ul>' . $form . "\n";
}

$inputs = array(
    'Product Name' => array(
        'type' => 'text',
        'label' => 'product_name',
        'name' => 'product_name',
        'id' => 'product_name',
        'value' => '',
    ),
    'Price' => array(
        'type' => 'text',
        'label' => 'price',
        'name' => 'price',
        'id' => 'price',
        'value' => '',
    ),
    'SKU' => array(
        'type' => 'text',
        'label' => 'sku',
        'name' => 'sku',
        'id' => 'sku',
        'value' => '',
    ),
    'Product Description' => array(
        'type' => 'textarea',
        'label' => 'product_description',
        'name' => 'product_description',
        'id' => 'product_description',
        'value' => '',
    ),
);
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Lab 2 Form</title>
        <style>
            label {
                display: block;
            }
            ul {
                list-style-type: none;
            }
        </style>
    </head>
    <body id="home-page" class="">
        <form action="" method="post">
            <?php echo getFormFieldsHtml($inputs); ?>
        </form>
    </body>
</html>
