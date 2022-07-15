import { useEffect, useState } from 'react';
import DatePicker from 'react-datepicker';
import { api } from '../../service/api';
import { TypeSale } from '../../types/TypeSale';
import { FormatDate, FormatIso8601 } from '../../utils/FormatDate';

import { NotificationButton } from '../NotificationButton';
import './styles.css';

const SalesCard = () => {
  const [data, setData] = useState<TypeSale[]>([]);
  const min = new Date(new Date().setDate(new Date().getDate() - 365));
  const max = new Date();
  const [minDate, setMinDate] = useState(min);
  const [maxDate, setMaxDate] = useState(max);

  useEffect(() => {
    (async () => {
      const dmin = FormatIso8601(minDate);
      const dmax = FormatIso8601(maxDate);
      console.log(dmin);
      await api(`/sales?page=0&size=6&minDate=${dmin}&maxDate=${dmax}`).then(
        response => {
          setData(response.data.content);
        }
      );
    })();
  }, [minDate, maxDate]);

  return (
    <div className='dsmeta-card'>
      <h2 className='dsmeta-sales-title'>Vendas</h2>
      <div>
        <div className='dsmeta-form-control-container'>
          <DatePicker
            selected={minDate}
            onChange={(date: Date) => setMinDate(date)}
            className='dsmeta-form-control'
            dateFormat='dd/MM/yyyy'
            isClearable
          />
        </div>
        <div className='dsmeta-form-control-container'>
          <DatePicker
            selected={maxDate}
            onChange={(date: Date) => setMaxDate(date)}
            className='dsmeta-form-control'
            dateFormat='dd/MM/yyyy'
            isClearable
          />
        </div>
      </div>
      <div>
        <table className='dsmeta-sales-table'>
          <thead>
            <tr>
              <th className='show992'>ID</th>
              <th className='show576'>Data</th>
              <th>Vendedor</th>
              <th className='show992'>Visitas</th>
              <th className='show992'>Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {data?.map(value => {
              return (
                <tr key={value.id}>
                  <td className='show992'>{value.id}</td>
                  <td className='show576'>{FormatDate(value.date)}</td>
                  <td>{value.sellerName}</td>
                  <td className='show992'>{value.visited}</td>
                  <td className='show992'>{value.deals}</td>
                  <td>R$ {value.amount.toFixed(2)}</td>
                  <td>
                    <div className='dsmeta-red-btn-container'>
                      <div className='dsmeta-red-btn'>
                        <NotificationButton saleId={value.id} />
                      </div>
                    </div>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export { SalesCard };
